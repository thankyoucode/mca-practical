# SET - 7

- CUSTOMER (cid, fname, lname, city, country, phone)

```sql
DROP TABLE IF EXISTS Customer;
CREATE TABLE Customer (
  cid INT PRIMARY KEY,
  fname VARCHAR(25) NOT NULL,
  lname VARCHAR(25),
  city VARCHAR(50) NOT NULL,
  country VARCHAR(50) NOT NULL,
  phone VARCHAR(15) NOT NULL
);

INSERT INTO Customer (cid, fname, lname, city, country, phone) VALUES
(1, 'Janak', 'Chaudhary', 'Deesa', 'India', '+91 9595959595'),
(2, 'Amit', 'Shah', 'Ahmedabad', 'India', '+91 9898989898'),
(3, 'Ravi', 'Patel', 'Surat', 'India', '+91 9797979797'),
(4, 'Neha', 'Mehta', 'Mumbai', 'India', '+91 9696969696'),
(5, 'Karan', 'Singh', 'Delhi', 'India', '+91 9594949494'),

(6, 'Li', 'Wang', 'Beijing', 'China', '+86 1010101010'),
(7, 'Chen', 'Lee', 'Shanghai', 'China', '+86 2020202020'),
(8, 'Zhang', 'Wei', 'Shenzhen', 'China', '+86 3030303030'),

(9, 'John', 'Smith', 'New York', 'USA', '+1 1111111111'),
(10, 'Emma', 'Brown', 'Chicago', 'USA', '+1 2222222222'),
(11, 'David', 'Miller', 'Boston', 'USA', '+1 3333333333'),
(12, 'Sophia', 'Wilson', 'Seattle', 'USA', '+1 4444444444'),
(13, 'Michael', 'Taylor', 'Austin', 'USA', '+1 5555555555'),

(14, 'Oliver', 'Jones', 'London', 'UK', '+44 6666666666'),
(15, 'Harry', 'Clark', 'Manchester', 'UK', '+44 7777777777'),
(16, 'Jack', 'Walker', 'Birmingham', 'UK', '+44 8888888888'),
(17, 'Noah', 'Hall', 'Leeds', 'UK', '+44 9999999999'),
(18, 'Leo', 'Young', 'Bristol', 'UK', '+44 1212121212');
```

- ORDER (oid, oDate, oNumber, cid, oTotalAmount)

```sql
DROP TABLE IF EXISTS Orders;

CREATE TABLE Orders (
  oid INT PRIMARY KEY,
  odate DATE NOT NULL,
  onumber INT NOT NULL,
  cid INT NOT NULL,
  ototalamount INT NOT NULL,
  FOREIGN KEY (cid) REFERENCES Customer(cid)
);

INSERT INTO Orders () VALUES
(101, '2024-01-15', 5001, 1, 5200),
(102, '2024-02-10', 5002, 1, 6100),
(103, '2024-03-05', 5003, 1, 5800),

(104, '2024-01-20', 5004, 2, 4500),
(105, '2024-02-18', 5005, 2, 4800),

(106, '2024-03-12', 5006, 3, 7000),
(107, '2024-04-25', 5007, 3, 7200),

(108, '2024-01-08', 5008, 4, 5500),
(109, '2024-02-14', 5009, 4, 6000),
(110, '2024-03-22', 5010, 4, 6200),

(111, '2024-05-01', 5011, 5, 8000),

(112, '2024-01-11', 5012, 9, 5000),
(113, '2024-02-19', 5013, 9, 5200),
(114, '2024-03-29', 5014, 9, 5400),
(115, '2024-04-10', 5015, 9, 5600),

(116, '2024-06-15', 5016, 10, 6500),
(117, '2024-07-18', 5017, 10, 6700),

(118, '2024-08-21', 5018, 14, 5900),
(119, '2024-09-05', 5019, 14, 6100),

(120, '2024-10-12', 5020, 15, 4800),
(121, '2024-11-25', 5021, 16, 5300),
(122, '2024-12-30', 5022, 17, 6200);
```

**1. List the number of customers in each country. Only include countries with more than 100 customers.**

```sql
SELECT country, COUNT(cid) AS country_customers
FROM Customer
GROUP BY country
HAVING country_customers > 100;
```

Not any

**2. List the number of customers in each country, except China, sorted high to low. Only include countries with 5 or more customers.**

```sql
SELECT country, COUNT(cid) AS country_customers
FROM Customer
WHERE country != 'China'
GROUP BY country
HAVING country_customers >= 5
ORDER BY country_customers;
```

| country | country_customers |
| ------- | ----------------- |
| India   | 5                 |
| USA     | 5                 |
| UK      | 5                 |

**3. List all customers with average orders between Rs.5000 and Rs.6500.**

```sql
SELECT AVG(o.ototalamount) AS avgAmount, c.*
FROM Orders AS o
NATURAL JOIN Customer AS c
GROUP BY cid
HAVING avgAmount BETWEEN 5000 AND 6500;
```

| avgAmount | cid | fname  | lname     | city       | country | phone          |
| --------- | --- | ------ | --------- | ---------- | ------- | -------------- |
| 5700.0000 | 1   | Janak  | Chaudhary | Deesa      | India   | +91 9595959595 |
| 5900.0000 | 4   | Neha   | Mehta     | Mumbai     | India   | +91 9696969696 |
| 5300.0000 | 9   | John   | Smith     | New York   | USA     | +1 1111111111  |
| 6000.0000 | 14  | Oliver | Jones     | London     | UK      | +44 6666666666 |
| 5300.0000 | 16  | Jack   | Walker    | Birmingham | UK      | +44 8888888888 |
| 6200.0000 | 17  | Noah   | Hall      | Leeds      | UK      | +44 9999999999 |

**4. Create a trigger that executes whenever country is updated in CUSTOMER table.**

- creating country change log table for tracking any update of country in Customer table

```sql
CREATE TABLE CountryChangeLog(
  cid INT NOT NULL,
  oldcountry VARCHAR(50) NOT NULL,
  newcountry VARCHAR(50) NOT NULL,
  updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (cid) REFERENCES Customer(cid)
);

DELIMITER //

CREATE TRIGGER inform_country_update_in_customer
BEFORE UPDATE ON Customer
FOR EACH ROW
BEGIN
  IF OLD.country <> NEW.country THEN
   INSERT INTO CountryChangeLog(cid, oldcountry, newcountry)
   VALUES(NEW.cid, OLD.country, NEW.country);
  END IF;
END //

DELIMITER ;

UPDATE Customer SET country='USA' WHERE cid=5;
UPDATE Customer SET country='India' WHERE cid=5;

SELECT * FROM CountryChangeLog;
```

| cid | oldcountry | newcountry | updated_at          |
| --- | ---------- | ---------- | ------------------- |
| 5   | India      | USA        | 2026-01-26 16:58:30 |
| 5   | USA        | India      | 2026-01-26 16:58:30 |

**5. Create a function to return customer with maximum orders.**

```sql
DELIMITER //

DROP FUNCTION IF EXISTS return_max_order_of_customer //

CREATE FUNCTION return_max_order_of_customer()
RETURNS INT
DETERMINISTIC
BEGIN
  DECLARE more_orders_cid INT;
  SELECT c.cid INTO more_orders_cid FROM Customer AS c
  JOIN Orders AS o ON c.cid = o.cid
  GROUP BY c.cid
  ORDER BY COUNT(oid) DESC
  LIMIT 1;
  RETURN more_orders_cid;
END //

DELIMITER ;


SELECT *
FROM Customer
WHERE cid = return_max_order_of_customer();
```

| cid | fname | lname | city     | country | phone         |
| --- | ----- | ----- | -------- | ------- | ------------- |
| 9   | John  | Smith | New York | USA     | +1 1111111111 |

**6. Create a procedure to display month names of dates of ORDER table. The month names should be unique.**

```sql
SELECT DISTINCT MONTHNAME(odate) AS 'month_name' FROM Orders;
```

| month_name |
| ---------- |
| January    |
| February   |
| March      |
| April      |
| May        |
| June       |
| July       |
| August     |
| September  |
| October    |
| November   |
| December   |
