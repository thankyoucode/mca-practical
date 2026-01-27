# SET - 5

**Create the database EXAM**

```sql
CREATE DATABASE exam;
USE exam;
```

**Create given tables with all necessary constraints such as primary key, foreign key, unique key, not null and check constraints.**

- APPLICANT (AID, ANAME, ADDR, ABIRTH_DT)

```sql
CREATE TABLE Applicant (
  aid INT PRIMARY KEY,
  aname VARCHAR(50) NOT NULL,
  address VARCHAR(100),
  dob DATE
);
INSERT INTO Applicant VALUES
(1, 'Amit Sharma', 'Delhi, India', '2001-05-12'),
(2, 'Priya Verma', 'Lucknow, India', '2000-11-22'),
(3, 'Rahul Mehta', 'Ahmedabad, India', '2001-02-18'),
(4, 'Sneha Patil', 'Pune, India', '2000-09-05'),
(5, 'Ankit Singh', 'Patna, India', '2001-07-30'),
(6, 'Neha Gupta', 'Jaipur, India', '1999-03-14'),
(7, 'Rohit Malhotra', 'Chandigarh, India', '1998-12-09'),
(8, 'Pooja Nair', 'Kochi, India', '1999-06-25'),
(9, 'Suresh Iyer', 'Chennai, India', '1998-10-17'),
(10, 'Kavita Rao', 'Bengaluru, India', '1999-01-08');
```

- ENTRANCE_TEST (ETID, ETNAME, MAX_SCORE, CUT_SCORE)

```sql
CREATE TABLE EntranceTest (
  etid INT PRIMARY KEY,
  etname VARCHAR(50) NOT NULL,
  max_score INT,
  cut_score INT
);

INSERT INTO EntranceTest VALUES
(101, 'NIMCET', 1000, 350),
(102, 'MAH-MCA-CET', 200, 80),
(201, 'CAT', 300, 150),
(202, 'MAT', 200, 90);
```

- ETEST_CENTRE (ETCID, LOCATION, INCHARGE, CAPACITY)

```sql
CREATE TABLE ETestCenter (
  etcid INT PRIMARY KEY,
  location VARCHAR(100) NOT NULL,
  incharge VARCHAR(50) NOT NULL,
  capacity INT
);

INSERT INTO ETestCenter VALUES
(1, 'Delhi', 'Dr. R. Kumar', 300),
(2, 'Mumbai', 'Ms. S. Joshi', 250),
(3, 'Bengaluru', 'Mr. A. Rao', 200),
(4, 'Chennai', 'Dr. P. Iyer', 220);
```

- ETEST_DETAILS (AID, ETID, ETCID, ETEST_DT, SCORE)

```sql
CREATE TABLE ETestDetails (
  aid INT NOT NULL,
  etid INT NOT NULL,
  etcid INT NOT NULL,
  etest_date DATE NOT NULL,
  score INT,
  FOREIGN KEY (aid) REFERENCES Applicant(aid),
  FOREIGN KEY (etid) REFERENCES EntranceTest(etid),
  FOREIGN KEY (etcid) REFERENCES ETestCenter(etcid)
);
INSERT INTO ETestDetails VALUES
(1, 101, 1, '2024-06-10', 420),
(2, 102, 2, '2024-06-12', 110),
(3, 101, 3, '2024-06-10', 390),
(4, 102, 4, '2024-06-12', 95),
(5, 101, 1, '2024-06-10', 450),
(6, 201, 2, '2024-11-20', 180),
(7, 201, 3, '2024-11-20', 165),
(8, 202, 4, '2024-12-05', 120),
(9, 202, 1, '2024-12-05', 130),
(10, 201, 2, '2024-11-20', 190);
```

(This database is for a common entrance test which is being conducted at a number of centers and can be taken by an applicant on any day except holidays)
Do as directed:

**1. Modify the APPLICANT table so that every applicant id has an ‘A’ before its value. E.g. if value is ‘1123’, it should become ‘A1123’.**

```sql
ALTER TABLE Applicant ADD aaid VARCHAR(20);

UPDATE Applicant
SET aaid = CONCAT('A', aid);

SELECT * FROM Applicant;
```

| aid | aname          | address           | dob        | aaid |
| --- | -------------- | ----------------- | ---------- | ---- |
| 1   | Amit Sharma    | Delhi, India      | 2001-05-12 | A1   |
| 2   | Priya Verma    | Lucknow, India    | 2000-11-22 | A2   |
| 3   | Rahul Mehta    | Ahmedabad, India  | 2001-02-18 | A3   |
| 4   | Sneha Patil    | Pune, India       | 2000-09-05 | A4   |
| 5   | Ankit Singh    | Patna, India      | 2001-07-30 | A5   |
| 6   | Neha Gupta     | Jaipur, India     | 1999-03-14 | A6   |
| 7   | Rohit Malhotra | Chandigarh, India | 1998-12-09 | A7   |
| 8   | Pooja Nair     | Kochi, India      | 1999-06-25 | A8   |
| 9   | Suresh Iyer    | Chennai, India    | 1998-10-17 | A9   |
| 10  | Kavita Rao     | Bengaluru, India  | 1999-01-08 | A10  |

**2. Display test center details where no tests were conducted.**

```sql
SELECT *
FROM ETestCenter
WHERE etcid NOT IN (
  SELECT etcid
  FROM ETestDetails
);
```

Not any

**3. Display details about applicants who have the same score as that of Ajaykumar in ‘ORACLE FUNDAMENTALS’.**

- my case name: Amit Sharma, in: NIMCET

```sql
SELECT * FROM
Applicant NATURAL JOIN ETestDetails
WHERE score = (
  SELECT score
  FROM Applicant
  NATURAL JOIN ETestDetails
  NATURAL JOIN EntranceTest
  WHERE aname='Amit Sharma' AND etname='NIMCET'
);
```

| aid | aname       | address      | dob        | aaid | etid | etcid | etest_date | score |
| --- | ----------- | ------------ | ---------- | ---- | ---- | ----- | ---------- | ----- |
| 1   | Amit Sharma | Delhi, India | 2001-05-12 | A1   | 101  | 1     | 2024-06-10 | 420   |

**4. Display details of applicants who appeared for all tests.**

this is bit complex one

```sql
SELECT a.*
FROM Applicant a
JOIN ETestDetails e ON a.aid=e.AID
GROUP BY a.aid, a.aname, a.address, a.dob
HAVING COUNT(DISTINCT e.etid) = (
  SELECT COUNT(*) FROM EntranceTest
);
```

Not any

**5. Display those tests where no applicant has failed.**

```sql
SELECT * FROM EntranceTest WHERE etid IN (
  SELECT etid
  FROM EntranceTest
  NATURAL JOIN ETestDetails
  NATURAL JOIN Applicant
  WHERE cut_score <= score
);
```

| etid | etname      | max_score | cut_score |
| ---- | ----------- | --------- | --------- |
| 101  | NIMCET      | 1000      | 350       |
| 102  | MAH-MCA-CET | 200       | 80        |
| 201  | CAT         | 300       | 150       |
| 202  | MAT         | 200       | 90        |

**6. Display details of entrance test centers which had full attendance between 1st Oct 15 and 15th Oct 16.**

```sql
SELECT *
FROM EntranceTest
NATURAL JOIN ETestDetails
NATURAL JOIN Applicant
WHERE etest_date BETWEEN '2023-10-01' AND '2024-10-15';
```

| aid | etid | etname      | max_score | cut_score | etcid | etest_date | score | aname       | address          | dob        | aaid |
| --- | ---- | ----------- | --------- | --------- | ----- | ---------- | ----- | ----------- | ---------------- | ---------- | ---- |
| 1   | 101  | NIMCET      | 1000      | 350       | 1     | 2024-06-10 | 420   | Amit Sharma | Delhi, India     | 2001-05-12 | A1   |
| 2   | 102  | MAH-MCA-CET | 200       | 80        | 2     | 2024-06-12 | 110   | Priya Verma | Lucknow, India   | 2000-11-22 | A2   |
| 3   | 101  | NIMCET      | 1000      | 350       | 3     | 2024-06-10 | 390   | Rahul Mehta | Ahmedabad, India | 2001-02-18 | A3   |
| 4   | 102  | MAH-MCA-CET | 200       | 80        | 4     | 2024-06-12 | 95    | Sneha Patil | Pune, India      | 2000-09-05 | A4   |
| 5   | 101  | NIMCET      | 1000      | 350       | 1     | 2024-06-10 | 450   | Ankit Singh | Patna, India     | 2001-07-30 | A5   |

**7. Display details of the applicants who scored more than the cut score in the tests they appeared in.**

```sql
SELECT * FROM Applicant WHERE aid IN (
  SELECT aid from ETestDetails
  NATURAL JOIN EntranceTest
  WHERE cut_score <= score
);
```

| aid | aname          | address           | dob        | aaid |
| --- | -------------- | ----------------- | ---------- | ---- |
| 1   | Amit Sharma    | Delhi, India      | 2001-05-12 | A1   |
| 3   | Rahul Mehta    | Ahmedabad, India  | 2001-02-18 | A3   |
| 5   | Ankit Singh    | Patna, India      | 2001-07-30 | A5   |
| 2   | Priya Verma    | Lucknow, India    | 2000-11-22 | A2   |
| 4   | Sneha Patil    | Pune, India       | 2000-09-05 | A4   |
| 6   | Neha Gupta     | Jaipur, India     | 1999-03-14 | A6   |
| 7   | Rohit Malhotra | Chandigarh, India | 1998-12-09 | A7   |
| 10  | Kavita Rao     | Bengaluru, India  | 1999-01-08 | A10  |
| 8   | Pooja Nair     | Kochi, India      | 1999-06-25 | A8   |
| 9   | Suresh Iyer    | Chennai, India    | 1998-10-17 | A9   |

**8. Display average and maximum score test wise of tests conducted at Mumbai.**

```sql
SELECT
  etid,
  AVG(score) AS average_score,
  MAX(score) AS maximum_score
FROM ETestCenter NATURAL JOIN ETestDetails
WHERE location = 'Mumbai'
GROUP BY etid;
```

| etid | average_score | maximum_score |
| ---- | ------------- | ------------- |
| 102  | 110.0000      | 110           |
| 201  | 185.0000      | 190           |

**9. Display the number of applicants who have appeared for each test, test center wise.**

```sql
SELECT etcid, etid, COUNT(aid) AS number_of_student_appeared
FROM ETestDetails
NATURAL JOIN ETestCenter
GROUP BY etid, etcid;
```

| etcid | etid | number_of_student_appeared |
| ----- | ---- | -------------------------- |
| 1     | 101  | 2                          |
| 1     | 202  | 1                          |
| 2     | 102  | 1                          |
| 2     | 201  | 2                          |
| 3     | 101  | 1                          |
| 3     | 201  | 1                          |
| 4     | 102  | 1                          |
| 4     | 202  | 1                          |

**10. Display details about test centers where no tests have been conducted.**

```sql
SELECT * from ETestCenter
WHERE etcid NOT IN (
  SELECT etcid FROM ETestDetails
);
```

Not any

**11. For tests, which have been conducted between 2-3-17 and 23-4-17, show details of the tests as well as the test centre.**

```sql
SELECT *
FROM ETestDetails NATURAL JOIN ETestCenter
WHERE etest_date BETWEEN '24-05-02' AND '24-06-17';
```

| etcid | aid | etid | etest_date | score | location  | incharge     | capacity |
| ----- | --- | ---- | ---------- | ----- | --------- | ------------ | -------- |
| 1     | 1   | 101  | 2024-06-10 | 420   | Delhi     | Dr. R. Kumar | 300      |
| 2     | 2   | 102  | 2024-06-12 | 110   | Mumbai    | Ms. S. Joshi | 250      |
| 3     | 3   | 101  | 2024-06-10 | 390   | Bengaluru | Mr. A. Rao   | 200      |
| 4     | 4   | 102  | 2024-06-12 | 95    | Chennai   | Dr. P. Iyer  | 220      |
| 1     | 5   | 101  | 2024-06-10 | 450   | Delhi     | Dr. R. Kumar | 300      |

**12. How many applicants appeared in the ‘ORACLE FUNDAMENTALS’ test at Chennai in the month of February?**

```sql
SELECT COUNT(aid)
FROM ETestDetails
NATURAL JOIN ETestCenter
NATURAL JOIN EntranceTest
WHERE
  location = 'Chennai'
  AND MONTH(etest_date) = 2
  AND etname = 'ORACLE FUNDAMENTALS';
```

| COUNT(aid) |
| ---------- |
| 0          |

**13. Display details about applicants who appeared for tests in the same month as the month in which they were born.**

```sql
SELECT A.*
FROM ETestDetails
NATURAL JOIN Applicant AS A
WHERE MONTH(etest_date) = MONTH(dob);
```

Not any

**14. Display the details about APPLICANTS who have scored the highest in each test, test centre wise.**

```sql
SELECT score, A.*
FROM ETestDetails
NATURAL JOIN Applicant AS A
WHERE (etid, etcid, score) IN (
  SELECT etid, etcid, MAX(score)
  FROM ETestDetails
  GROUP BY etid, etcid
);
```

| score | aid | aname          | address           | dob        | aaid |
| ----- | --- | -------------- | ----------------- | ---------- | ---- |
| 110   | 2   | Priya Verma    | Lucknow, India    | 2000-11-22 | A2   |
| 390   | 3   | Rahul Mehta    | Ahmedabad, India  | 2001-02-18 | A3   |
| 95    | 4   | Sneha Patil    | Pune, India       | 2000-09-05 | A4   |
| 450   | 5   | Ankit Singh    | Patna, India      | 2001-07-30 | A5   |
| 165   | 7   | Rohit Malhotra | Chandigarh, India | 1998-12-09 | A7   |
| 120   | 8   | Pooja Nair     | Kochi, India      | 1999-06-25 | A8   |
| 130   | 9   | Suresh Iyer    | Chennai, India    | 1998-10-17 | A9   |
| 190   | 10  | Kavita Rao     | Bengaluru, India  | 1999-01-08 | A10  |

**15. Design a read only view, which has details about applicants and the tests that he has appeared for.**

```sql
CREATE VIEW StudentTest AS
SELECT A.*, ET.*
FROM ETestDetails
NATURAL JOIN Applicant AS A
NATURAL JOIN EntranceTest AS ET;
-- Using View
SELECT * FROM StudentTest;
```

| aid | aname          | address           | dob        | aaid | etid | etname      | max_score | cut_score |
| --- | -------------- | ----------------- | ---------- | ---- | ---- | ----------- | --------- | --------- |
| 1   | Amit Sharma    | Delhi, India      | 2001-05-12 | A1   | 101  | NIMCET      | 1000      | 350       |
| 3   | Rahul Mehta    | Ahmedabad, India  | 2001-02-18 | A3   | 101  | NIMCET      | 1000      | 350       |
| 5   | Ankit Singh    | Patna, India      | 2001-07-30 | A5   | 101  | NIMCET      | 1000      | 350       |
| 2   | Priya Verma    | Lucknow, India    | 2000-11-22 | A2   | 102  | MAH-MCA-CET | 200       | 80        |
| 4   | Sneha Patil    | Pune, India       | 2000-09-05 | A4   | 102  | MAH-MCA-CET | 200       | 80        |
| 6   | Neha Gupta     | Jaipur, India     | 1999-03-14 | A6   | 201  | CAT         | 300       | 150       |
| 7   | Rohit Malhotra | Chandigarh, India | 1998-12-09 | A7   | 201  | CAT         | 300       | 150       |
| 10  | Kavita Rao     | Bengaluru, India  | 1999-01-08 | A10  | 201  | CAT         | 300       | 150       |
| 8   | Pooja Nair     | Kochi, India      | 1999-06-25 | A8   | 202  | MAT         | 200       | 90        |
| 9   | Suresh Iyer    | Chennai, India    | 1998-10-17 | A9   | 202  | MAT         | 200       | 90        |

**16. Write a procedure which will print maximum score centre wise.**

```sql
DELIMITER //

CREATE PROCEDURE MaxScorePerCenter()
BEGIN
  SELECT etcid, MAX(score)
  FROM ETestDetails
  GROUP BY etcid;
END //

DELIMITER ;

CALL MaxScorePerCenter();
```

| etcid | MAX(score) |
| ----- | ---------- |
| 1     | 450        |
| 2     | 190        |
| 3     | 390        |
| 4     | 120        |

**17. Write a procedure which will print details of entrance test showing Centre name, candidate id, date and score**

```sql
DELIMITER //

CREATE PROCEDURE SimpleTestInfo()
BEGIN
  SELECT location, aid, etest_date, score
  FROM ETestDetails
  NATURAL JOIN ETestCenter
  NATURAL JOIN Applicant;
END //

DELIMITER ;

CALL SimpleTestInfo();
```

| location  | aid | etest_date | score |
| --------- | --- | ---------- | ----- |
| Delhi     | 1   | 2024-06-10 | 420   |
| Delhi     | 5   | 2024-06-10 | 450   |
| Delhi     | 9   | 2024-12-05 | 130   |
| Mumbai    | 2   | 2024-06-12 | 110   |
| Mumbai    | 6   | 2024-11-20 | 180   |
| Mumbai    | 10  | 2024-11-20 | 190   |
| Bengaluru | 3   | 2024-06-10 | 390   |
| Bengaluru | 7   | 2024-11-20 | 165   |
| Chennai   | 4   | 2024-06-12 | 95    |
| Chennai   | 8   | 2024-12-05 | 120   |

**18. Write a trigger which do not allow insertion / updation / deletion of Enterance test details on Sunday.**

```sql
DELIMITER //

CREATE PROCEDURE PreventSundayOperation()
BEGIN
  IF DAYOFWEEK(NOW()) = 1 THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Operation not allowed on Sunday';
  END IF;
END //

CREATE TRIGGER NoInsertOnSunday
BEFORE INSERT ON ETestDetails
FOR EACH ROW
BEGIN
  CALL PreventSundayOperation();
END //


CREATE TRIGGER NoUpdateOnSunday
BEFORE UPDATE ON ETestDetails
FOR EACH ROW
BEGIN
  CALL PreventSundayOperation();
END //


CREATE TRIGGER NoDeleteOnSunday
BEFORE DELETE ON ETestDetails
FOR EACH ROW
BEGIN
  CALL PreventSundayOperation();
END //

DELIMITER ;

-- Today (25-01-2026) is Sunday let's check to run this 3 operation on ETestDetails
INSERT INTO ETestDetails VALUES
(11, 102, 3, '2024-02-23', 340);

UPDATE ETestDetails SET score = 200 WHERE aid = 4;

DELETE FROM ETestDetails WHERE aid = 4;
```

```plaintext
mysql> INSERT INTO ETestDetails VALUES
-> (11, 102, 3, '2024-02-23', 340);
ERROR 1644 (45000): Operation not allowed on Sunday
mysql> UPDATE ETestDetails SET score = 200 WHERE aid = 4;
ERROR 1644 (45000): Operation not allowed on Sunday
mysql> DELETE FROM ETestDetails WHERE aid = 4;
ERROR 1644 (45000): Operation not allowed on Sunday
```
