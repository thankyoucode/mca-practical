# SET - 3

## Create the following table: Salesmen, Customers, Orders

```sql
DROP TABLE Orders;
DROP TABLE Customers;
DROP TABLE Salesman;
```

- Salesmen table (SNUM, SNAME , CITY , COMMISSION)
  SNUM : A unique number assigned to each salesman.
  SNAME :The name of salesman.
  CITY :The location of salesmen.
  COMMISSION: The Salemen's commission on orders

```sql
CREATE TABLE Salesman (
  snum INT PRIMARY KEY,
  sname VARCHAR(50) NOT NULL,
  city VARCHAR(50),
  commission DECIMAL(20, 2)
);
```

- Customers (CNUM, CNAME , CITY , RATING , SNUM)
  CNUM : A unique number assigned to each customer.
  CNAME : The name of the customer.
  CITY : The location of the customer.
  RATING : A level of preference indicator given to this customer.
  SNUM : The number of salesman assigned to this customer.

```sql
CREATE TABLE Customers (
  cnum INT PRIMARY KEY,
  cname VARCHAR(50) NOT NULL,
  city VARCHAR(50),
  rating DECIMAL(5, 1),
  snum INT NOT NULL,
  FOREIGN KEY (snum) REFERENCES Salesman(snum)
);
```

- Orders (ONUM, AMOUNT, ODATE, CNUM, SNUM)
  ONUM : A unique number assigned to each order.
  AMOUNT : The amount of an order.
  ODATE : The date of an order.
  CNUM : The number of customer making the order.
  SNUM : The number of salesman credited with the sale.

```sql
CREATE TABLE Orders (
  onum INT PRIMARY KEY,
  amount INT,
  ODATE DATE,
  cnum INT NOT NULL,
  snum INT NOT NULL,
  FOREIGN KEY (cnum) REFERENCES Customers(cnum),
  FOREIGN KEY (snum) REFERENCES Salesman(snum)
);
```

**1. Write an Insert script for insertion of rows with substitution variables and insert appropriate data**

```sql
INSERT INTO Salesman values(1, 'Sujal', 'Deesa', 5.2);
INSERT INTO Salesman values(2, 'Bhavesh', 'Lakhani', 4);
INSERT INTO Salesman values(3, 'Ralul', 'Patal', 4.5);
INSERT INTO Salesman values(4, 'Gaurav', 'Mahesana', 4.3);
INSERT INTO Salesman values(5, 'Rajvir', 'Rampur', 3.3);

INSERT INTO Customers values(1, 'Krunal', 'Sherpura', 2.7, 5);
INSERT INTO Customers values(2, 'Janak', 'Yaverpura', 3.3, 4);
INSERT INTO Customers values(3, 'Dashrath', 'Yaverpura', 4.2, 3);
INSERT INTO Customers values(4, 'Shubham', 'Deesa', 4.5, 2);
INSERT INTO Customers values(5, 'Mical', 'Deesa', 3.2, 1);
```

**2. Produce the order no, amount and date of all orders.**

```sql
INSERT INTO Orders values(1, 1000, '2025-01-10', 1, 5);
INSERT INTO Orders values(2, 2000, '2025-02-10', 2, 4);
INSERT INTO Orders values(3, 3000, '2025-03-10', 3, 3);
INSERT INTO Orders values(4, 4000, '2025-05-10', 4, 2);
INSERT INTO Orders values(5, 5000, '2025-06-10', 5, 1);
```

**3. Give all the information about all the customers with a specific salesman number.**

```sql
SELECT * FROM Customers WHERE snum = 5;
```

| cnum | cname  | city     | rating | snum |
| ---- | ------ | -------- | ------ | ---- |
| 1    | Krunal | Sherpura | 2.7    | 5    |

**4. Display the following information in the order of city, sname, snum and commission**

```sql
SELECT city, sname, snum, commission FROM Salesman;
```

| city     | sname   | snum | commission |
| -------- | ------- | ---- | ---------- |
| Deesa    | Sujal   | 1    | 5.20       |
| Lakhani  | Bhavesh | 2    | 4.00       |
| Patal    | Ralul   | 3    | 4.50       |
| Mahesana | Gaurav  | 4    | 4.30       |
| Rampur   | Rajvir  | 5    | 3.30       |

**5. List of rating followed by the name of each customer in particular one city e.g. Surat. in my case Deesa**

```sql
SELECT cname, rating, city FROM Customers WHERE city = 'Deesa';
```

| cname   | rating | city  |
| ------- | ------ | ----- |
| Shubham | 4.5    | Deesa |
| Mical   | 3.2    | Deesa |

**6. List of snum of all salesmen with orders in order table without any duplicates.**

```sql
SELECT s.*, o.cnum ,o.onum, o.amount, o.ODATE FROM Orders o JOIN Salesman s ON o.snum = s.snum;
```

| snum | sname   | city     | commission | cnum | onum | amount | ODATE      |
| ---- | ------- | -------- | ---------- | ---- | ---- | ------ | ---------- |
| 5    | Rajvir  | Rampur   | 3.30       | 1    | 1    | 1000   | 2025-01-10 |
| 4    | Gaurav  | Mahesana | 4.30       | 2    | 2    | 2000   | 2025-02-10 |
| 3    | Ralul   | Patal    | 4.50       | 3    | 3    | 3000   | 2025-03-10 |
| 2    | Bhavesh | Lakhani  | 4.00       | 4    | 4    | 4000   | 2025-05-10 |
| 1    | Sujal   | Deesa    | 5.20       | 5    | 5    | 5000   | 2025-06-10 |

**7. List of all orders for more than certain amount e.g. more than Rs. 1000**

```sql
SELECT * FROM Orders WHERE amount > 1000;
```

| onum | amount | ODATE      | cnum | snum |
| ---- | ------ | ---------- | ---- | ---- |
| 2    | 2000   | 2025-02-10 | 2    | 4    |
| 3    | 3000   | 2025-03-10 | 3    | 3    |
| 4    | 4000   | 2025-05-10 | 4    | 2    |
| 5    | 5000   | 2025-06-10 | 5    | 1    |

**8. List of names and cities of all salesmen in one city e.g. London with commission above 10% -- in my case Patan 3%**

```sql
SELECT * FROM Salesman WHERE city = 'Patal' AND commission > 3;
```

| snum | sname | city  | commission |
| ---- | ----- | ----- | ---------- |
| 3    | Ralul | Patal | 4.50       |

**9. List all customers whose names begins with a letter 'C'.**

```sql
SELECT * FROM Customers WHERE cname LIKE 'C%';
```

Not any

```sql
SELECT * FROM Customers WHERE cname LIKE 'J%';
```

| cnum | cname | city      | rating | snum |
| ---- | ----- | --------- | ------ | ---- |
| 2    | Janak | Yaverpura | 3.3    | 4    |

**10. List all customers whose names begins with letter 'A' to 'G'.**

```sql
SELECT * FROM Customers WHERE cname BETWEEN 'A' AND 'G';
```

| cnum | cname    | city      | rating | snum |
| ---- | -------- | --------- | ------ | ---- |
| 3    | Dashrath | Yaverpura | 4.2    | 3    |

**11. List all orders with zero or NULL amount.**

```sql
SELECT * FROM Orders WHERE amount = NULL OR amount = 0;
```

Not any

**12. Find out the largest orders of salesman from two value e.g. 1002 and 1007**
-- ID in my case 2 and 4

```sql
SELECT MAX(amount), snum FROM Orders WHERE snum = 2 OR snum = 4 GROUP BY snum;
```

| MAX(amount) | snum |
| ----------- | ---- |
| 4000        | 2    |
| 2000        | 4    |

**13. Count all orders of particular date e.g. October 3, 2023**

```sql
SELECT * FROM Orders WHERE ODATE = '2025-06-10';
```

| onum | amount | ODATE      | cnum | snum |
| ---- | ------ | ---------- | ---- | ---- |
| 5    | 5000   | 2025-06-10 | 5    | 1    |

**14. Calculate the total amount ordered**

```sql
SELECT SUM(amount) AS Total_Amount FROM Orders;
```

| Total_Amount |
| ------------ |
| 15000        |

**15. Calculate the average amount ordered.**

```sql
SELECT AVG(amount) AS Average_Amount FROM Orders;
```

| Average_Amount |
| -------------- |
| 3000.0000      |

**16. Count the no. of salesmen currently having orders**

```sql
SELECT COUNT(DISTINCT snum) AS Total_Active_Salesman FROM Orders;
```

| Total_Active_Salesman |
| --------------------- |
| 5                     |

**17. List all salesmen with their % of commission**

```sql
SELECT snum, sname, commission from Salesman;
```

| snum | sname   | commission |
| ---- | ------- | ---------- |
| 1    | Sujal   | 5.20       |
| 2    | Bhavesh | 4.00       |
| 3    | Ralul   | 4.50       |
| 4    | Gaurav  | 4.30       |
| 5    | Rajvir  | 3.30       |

**18. Assume each salesperson has a 15% commission. Write a query on the order table that will produce the order number, salesman no and the amount of commission for that order**

```sql
SELECT onum, snum, amount, amount\*.15 AS Commission_15_Per FROM Orders;
```

| onum | snum | amount | Commission_15_Per |
| ---- | ---- | ------ | ----------------- |
| 1    | 5    | 1000   | 150.00            |
| 2    | 4    | 2000   | 300.00            |
| 3    | 3    | 3000   | 450.00            |
| 4    | 2    | 4000   | 600.00            |
| 5    | 1    | 5000   | 750.00            |

**19. Find the highest rating in each city in the form : For the city (city), the highest rating is : (rating)**

```sql
SELECT city, rating FROM Customers GROUP BY city, rating;
```

| city      | rating |
| --------- | ------ |
| Sherpura  | 2.7    |
| Yaverpura | 3.3    |
| Yaverpura | 4.2    |
| Deesa     | 4.5    |
| Deesa     | 3.2    |

**20. List all in descending order by rating.**

```sql
SELECT o.\*, c.rating FROM Orders o JOIN Customers c ON o.cnum = c.cnum ORDER BY c.rating;
```

| onum | amount | ODATE      | cnum | snum | rating |
| ---- | ------ | ---------- | ---- | ---- | ------ |
| 1    | 1000   | 2025-01-10 | 1    | 5    | 2.7    |
| 5    | 5000   | 2025-06-10 | 5    | 1    | 3.2    |
| 2    | 2000   | 2025-02-10 | 2    | 4    | 3.3    |
| 3    | 3000   | 2025-03-10 | 3    | 3    | 4.2    |
| 4    | 4000   | 2025-05-10 | 4    | 2    | 4.5    |

**21. Calculate the total of orders for each day and place the result in descending order.**

```sql
SELECT ODATE, COUNT(onum) AS TOTAL_ORDER_ON_THIS_DATE FROM Orders GROUP BY ODATE;
```

| ODATE      | TOTAL_ORDER_ON_THIS_DATE |
| ---------- | ------------------------ |
| 2025-01-10 | 1                        |
| 2025-02-10 | 1                        |
| 2025-03-10 | 1                        |
| 2025-05-10 | 1                        |
| 2025-06-10 | 1                        |

**22. Show the name of all customers with their salesman's name.**

```sql
SELECT cname, sname FROM Customers c JOIN Salesman s ON c.snum = s.snum;
```

| cname    | sname   |
| -------- | ------- |
| Krunal   | Rajvir  |
| Janak    | Gaurav  |
| Dashrath | Ralul   |
| Shubham  | Bhavesh |
| Mical    | Sujal   |

**23. List all customers and salesmen who shared a same city.**

```sql
SELECT cname, sname FROM Customers c JOIN Salesman s ON c.snum = s.snum AND c.city = s.city;
```

| cname | sname |
| ----- | ----- |
| Mical | Sujal |

**24. List all orders with the names of their customer and salesman.**

```sql
SELECT o.\*, cname, sname FROM Orders o JOIN Customers c ON o.cnum = c.cnum JOIN Salesman s ON o.snum = s.snum;
```

| onum | amount | ODATE      | cnum | snum | cname    | sname   |
| ---- | ------ | ---------- | ---- | ---- | -------- | ------- |
| 1    | 1000   | 2025-01-10 | 1    | 5    | Krunal   | Rajvir  |
| 2    | 2000   | 2025-02-10 | 2    | 4    | Janak    | Gaurav  |
| 3    | 3000   | 2025-03-10 | 3    | 3    | Dashrath | Ralul   |
| 4    | 4000   | 2025-05-10 | 4    | 2    | Shubham  | Bhavesh |
| 5    | 5000   | 2025-06-10 | 5    | 1    | Mical    | Sujal   |

**25. List all orders by the customers not located in the same city as their salesman.**

```sql
SELECT cname, sname FROM Customers c JOIN Salesman s ON c.snum = s.snum AND c.city != s.city;
```

| cname    | sname   |
| -------- | ------- |
| Krunal   | Rajvir  |
| Janak    | Gaurav  |
| Dashrath | Ralul   |
| Shubham  | Bhavesh |

**26. List all customers serviced by salespeople with commission above 15%.**

```sql
SELECT c.* FROM Customers c join Salesman s ON c.snum = s.snum WHERE s.commission > 15;
```

Not any

**27. Calculate the amount of the salesman commission on each order by a customer with rating above 100.**

```sql
SELECT o.*, o.amount*s.commission AS Salesman_Commission FROM Orders o JOIN Customers c ON o.cnum = c.cnum JOIN Salesman s ON o.snum = s.snum WHERE c.rating > 100;
```

Not any

**28. Find all pairs of customers having the same rating without duplication.**

```sql
SELECT c1.cname, c2.cname FROM Customers c1 JOIN Customers c2 ON c1.rating = c2.rating AND c1.cnum != c2.cnum;
```

Not any

**29. List all orders that are greater than the average of October 4,2023.**

```sql
SELECT * FROM Orders WHERE amount > (SELECT AVG(AMOUNT) FROM Orders WHERE ODATE = '2025-10-04');
```

Not any

```sql
SELECT AVG(AMOUNT) FROM Orders WHERE ODATE = '2025-01-10';
```

| AVG(AMOUNT) |
| ----------- |
| 1000.0000   |

```sql
SELECT * FROM Orders WHERE amount > (SELECT AVG(AMOUNT) FROM Orders WHERE ODATE = '2025-01-10');
```

| onum | amount | ODATE      | cnum | snum |
| ---- | ------ | ---------- | ---- | ---- |
| 2    | 2000   | 2025-02-10 | 2    | 4    |
| 3    | 3000   | 2025-03-10 | 3    | 3    |
| 4    | 4000   | 2025-05-10 | 4    | 2    |
| 5    | 5000   | 2025-06-10 | 5    | 1    |

**30. Find the average commission of salesmen in London.**

```sql
SELECT AVG(commission) FROM Salesman WHERE city = 'London';
```

| AVG(commission) |
| --------------- |
| NULL            |

```sql
SELECT AVG(commission) FROM Salesman WHERE city = 'Deesa';
```

| AVG(commission) |
| --------------- |
| 5.200000        |

**31. Find all orders attributed to salesmen in 'London' using both the subquery and join methods.**

```sql
SELECT * FROM Orders WHERE snum = (SELECT snum FROM Salesman WHERE city = 'London'); -- using subquery
SELECT o.* FROM Orders o JOIN Salesman s ON o.snum = s.snum WHERE s.city = 'London'; -- using join
```

Not any

```sql
SELECT * FROM Orders WHERE snum = (SELECT snum FROM Salesman WHERE city = 'Deesa'); -- using subquery
SELECT o.* FROM Orders o JOIN Salesman s ON o.snum = s.snum WHERE s.city = 'Deesa'; -- using join
```

| onum | amount | ODATE      | cnum | snum |
| ---- | ------ | ---------- | ---- | ---- |
| 5    | 5000   | 2025-06-10 | 5    | 1    |

**32. List the commission of all salesmen serving customers in 'London'.**

```sql
SELECT s.\* FROM Salesman s JOIN Customers c ON s.snum = c.snum WHERE c.city = 'London';
```

Not any

```sql
SELECT s.\* FROM Salesman s JOIN Customers c ON s.snum = c.snum WHERE c.city = 'Deesa';
```

| snum | sname   | city    | commission |
| ---- | ------- | ------- | ---------- |
| 2    | Bhavesh | Lakhani | 4.00       |
| 1    | Sujal   | Deesa   | 5.20       |

**33. Find all customers whose cnum is e.g. 1000 above than the snum of name e.g. Sejal.**

```sql
SELECT c.* FROM Customers c JOIN Salesman s ON c.cnum > s.snum WHERE s.sname = 'Sejal';
```

Not any

```sql
SELECT c.* FROM Customers c JOIN Salesman s ON c.cnum > s.snum WHERE s.sname = 'Sujal';
```

| cnum | cname    | city      | rating | snum |
| ---- | -------- | --------- | ------ | ---- |
| 2    | Janak    | Yaverpura | 3.3    | 4    |
| 3    | Dashrath | Yaverpura | 4.2    | 3    |
| 4    | Shubham  | Deesa     | 4.5    | 2    |
| 5    | Mical    | Deesa     | 3.2    | 1    |

**34. Count the no. of customers with the rating above than the average of one city e.g. 'Surat'.**

```sql
SELECT COUNT(cnum) FROM Customers WHERE rating > (SELECT AVG(rating) FROM Customers WHERE city = 'Surat');
```

| COUNT(cnum) |
| ----------- |
| 0           |

```sql
SELECT COUNT(cnum) FROM Customers WHERE rating > (SELECT AVG(rating) FROM Customers WHERE city = 'Yaverpura');
```

| COUNT(cnum) |
| ----------- |
| 2           |

**35. Find all salesmen with customers located in their cities using ANY and IN.**

```sql
SELECT * FROM Salesman WHERE city IN (SELECT city FROM Customers);
SELECT * FROM Salesman WHERE city = ANY (SELECT city FROM Customers);
```

both return same result

| snum | sname | city  | commission |
| ---- | ----- | ----- | ---------- |
| 1    | Sujal | Deesa | 5.20       |

**36. Find all salesmen for whom there are customers that follow them in alphabetical order.**

```sql
SELECT cname, sname FROM Customers c JOIN Salesman s ON c.snum = s.snum ORDER BY sname;
```

| cname    | sname   |
| -------- | ------- |
| Shubham  | Bhavesh |
| Janak    | Gaurav  |
| Krunal   | Rajvir  |
| Dashrath | Ralul   |
| Mical    | Sujal   |

**37. Find all customers having rating greater than any customer in particular city e.g. 'Rajkot'.**

```sql
SELECT * FROM Customers WHERE rating > (SELECT AVG(rating) FROM Customers WHERE city = 'Deesa');
```

| cnum | cname    | city      | rating | snum |
| ---- | -------- | --------- | ------ | ---- |
| 3    | Dashrath | Yaverpura | 4.2    | 3    |
| 4    | Shubham  | Deesa     | 4.5    | 2    |

**38. List all orders that has amount greater than at leat one of the orders from 6th October, 2023.**

```sql
SELECT * FROM Orders WHERE amount IN (SELECT AVG(amount) FROM Orders WHERE ODATE = '2023-10-06');
```

Not any

```sql
SELECT * FROM Orders WHERE amount IN (SELECT AVG(amount) FROM Orders WHERE ODATE = '2025-01-10');
```

| onum | amount | ODATE      | cnum | snum |
| ---- | ------ | ---------- | ---- | ---- |
| 1    | 1000   | 2025-01-10 | 1    | 5    |

**39. Find all orders with amounts smaller than any amount for a customer in 'London'.**

```sql
SELECT * FROM Orders WHERE amount < ANY (SELECT o.amount FROM Orders o JOIN Customers c ON o.cnum =c.cnum WHERE c.city = 'London');
```

Not any

```sql
SELECT * FROM Orders WHERE amount < ANY (SELECT o.amount FROM Orders o JOIN Customers c ON o.cnum =c.cnum WHERE c.city = 'Deesa');
```

| onum | amount | ODATE      | cnum | snum |
| ---- | ------ | ---------- | ---- | ---- |
| 1    | 1000   | 2025-01-10 | 1    | 5    |
| 2    | 2000   | 2025-02-10 | 2    | 4    |
| 3    | 3000   | 2025-03-10 | 3    | 3    |
| 4    | 4000   | 2025-05-10 | 4    | 2    |

**40. Find all the customers who have greater rating than every customer in one city e.g. 'Anand’**

```sql
SELECT * FROM Customers WHERE rating > ALL (SELECT rating FROM Customers WHERE city = 'Anand');
```

| cnum | cname    | city      | rating | snum |
| ---- | -------- | --------- | ------ | ---- |
| 1    | Krunal   | Sherpura  | 2.7    | 5    |
| 2    | Janak    | Yaverpura | 3.3    | 4    |
| 3    | Dashrath | Yaverpura | 4.2    | 3    |
| 4    | Shubham  | Deesa     | 4.5    | 2    |
| 5    | Mical    | Deesa     | 3.2    | 1    |

```sql
SELECT * FROM Customers WHERE rating > ALL (SELECT rating FROM Customers WHERE city = 'Sherpura');
```

| cnum | cname    | city      | rating | snum |
| ---- | -------- | --------- | ------ | ---- |
| 2    | Janak    | Yaverpura | 3.3    | 4    |
| 3    | Dashrath | Yaverpura | 4.2    | 3    |
| 4    | Shubham  | Deesa     | 4.5    | 2    |
| 5    | Mical    | Deesa     | 3.2    | 1    |

**41. Create a union of two queries that shows the names, cities and ratings of all customers. Those with rating of >=200 should display 'HIGH RATING' and those with < 200 should display 'LOW RATING'.**

```sql
SELECT cname, city, 'HIGH RATTING' FROM Customers WHERE rating >= 3.5 UNION SELECT cname, city, 'LOW RATING' FROM Customers WHERE rating < 3.5;
```

| cname    | city      | HIGH RATTING |
| -------- | --------- | ------------ |
| Dashrath | Yaverpura | HIGH RATTING |
| Shubham  | Deesa     | HIGH RATTING |
| Krunal   | Sherpura  | LOW RATING   |
| Janak    | Yaverpura | LOW RATING   |
| Mical    | Deesa     | LOW RATING   |

**42. Produce the name and number of each salesman and each customer with more than one current order in the alphabetical order of names.**

```sql
SELECT s.sname, s.snum FROM Salesman s JOIN Orders o ON s.snum = o.snum WHERE 1 < (SELECT count(snum) FROM Salesman WHERE snum = o.snum) ORDER BY s.sname;
```

Not any

**43. Create union of three queries. First select snum of all salesman in Surat, second, the cnum of all customers in 'Surat' and third, the onum of all orders of 3rd Oct. Retain duplicates between the last two queries but remove the duplicates between either of them and the first.**

```sql
SELECT snum FROM Salesman WHERE city='Sural' UNION (
SELECT cnum FROM Customers WHERE city='Sural' UNION ALL
SELECT onum FROM Orders WHERE ODATE='2025-10-04'
);
```

Not any

**44. Remove all orders from customer Chirag from the orders table.**

```sql
DELETE FROM Orders WHERE cnum = (SELECT cnum FROM Customers WHERE cname = 'Chirag');
```

**45. Set the ratings of all the customers of Piyush to 400.**

```sql
UPDATE Customers SET rating = 400 WHERE snum = (
SELECT snum FROM Salesman WHERE sname = 'Piyush'
);
```

**46. Increase the rating of all customers in Rome by 100.**

```sql
UPDATE Customers SET rating = (rating + 100) WHERE city = 'Rome';
```
