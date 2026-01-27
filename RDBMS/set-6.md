# SET - 6

- DEPT (deptno, deptnm)

```sql
CREATE TABLE Department (
  deptno INT PRIMARY KEY,
  deptnm VARCHAR(50) NOT NULL
);
INSERT INTO Department VALUES
(10, 'Account'),
(20, 'HR'),
(30, 'Production'),
(40, 'Sales'),
(50, 'Marketing');
```

- EMP (empno, empnm, empadd, salary, date_birth, joindt, deptno)

```sql
CREATE TABLE Employee (
  empno INT PRIMARY KEY,
  empnm VARCHAR(50) NOT NULL,
  empadd VARCHAR(100),
  date_birth DATE,
  joindt DATE,
  deptno INT,
  FOREIGN KEY (deptno) REFERENCES Department(deptno)
);

INSERT INTO Employee VALUES
(1, 'Krunal', 'Sherpura, Deesa', '2004-04-02', '2025-08-17', 10),
(2, 'Janak', 'Yaverpura, Deesa', '2003-05-23', '2023-02-16', 20),
(3, 'Dasharath', 'Yaverpura, Deesa', '2005-10-12', '2022-06-23', 30),
(4, 'Shubham', 'Deesa', '2003-02-22', '2022-09-22', 40),
(5, 'Sujal', 'Deesa', '2003-03-02', '2022-03-02', 50);
```

**Write a PL/SQL block (table above EMP-DEPT table) which takes as input Department name and displays all the employees of this department who has been working since last five years**

```sql
DROP PROCEDURE IF EXISTS ShowEmpFromLast5Year;

DELIMITER //

CREATE PROCEDURE ShowEmpFromLast5Year(IN deptName VARCHAR(50))
BEGIN
  SELECT E.*
  FROM Employee AS E
  NATURAL JOIN Department
  WHERE deptnm = deptName AND joindt >= DATE_SUB(CURDATE(), INTERVAL 5 YEAR);
END //

DELIMITER ;


CALL ShowEmpFromLast5Year('Account');
```

| empno | empnm  | empadd          | date_birth | joindt     | deptno |
| ----- | ------ | --------------- | ---------- | ---------- | ------ |
| 1     | Krunal | Sherpura, Deesa | 2004-04-02 | 2025-08-17 | 10     |
