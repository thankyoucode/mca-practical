# SET - 2

## DEPARTMENT (dept_no, dept_name, location) & EMPLOYEE (emp_id, emp_name, birth_date, gender, dept_no, address, designation, salary, experience, email)

**DROP TABLE Department; DROP TABLE Employee;**

**1. Create DEPT table with neccessary constraint such as DEPARTMENT (dept_no, dept_name, location) Department no should be primary key, department name should be unique.**

```sql
CREATE TABLE Department (
  dept_no INT PRIMARY KEY,
  dept_name VARCHAR(100) NOT NULL UNIQUE,
  location VARCHAR(100)
);
```

**2. Create the EMP Table with all necessary constraints such as In EMP TABLE: EMPLOYEE (emp_id, emp_name, birth_date, gender, dept_no, address, designation, salary, experience, email)**

- Employee idshould be primary key,
- Department no should be Foreign key,
- employee age (birth_date) should be greater than 18 years,
- salary should be greater than zero,
- email address should have (@ and dot) sign,
- designation of employee can be “manager”, “clerk”, “leader”, “analyst”, “designer”, “coder”, “tester”.

```sql
CREATE TABLE Employee (
  emp_id INT PRIMARY KEY,
  emp_name VARCHAR(100) NOT NULL,
  email VARCHAR(100) CHECK (email LIKE '%@%.%') NOT NULL,
  birth_date DATE NOT NULL,
  gender VARCHAR(6),
  dept_no INT NOT NULL,
  address VARCHAR(100),
  designation VARCHAR(10) CHECK (designation in ('manager', 'clerk', 'leader', 'analyst', 'designer', 'coder', 'tester')),
  salary INT CHECK (salary > 0),
  experience INT,
  FOREIGN KEY (dept_no) REFERENCES Department(dept_no)
);
```

**3. Modify Employee table by adding the constraints as 'Male' or 'Female' in gender field and display the structure.**

```sql
ALTER TABLE Employee ADD CONSTRAINT gender CHECK (gender in ('Male', 'Female'));
DESCRIBE Employee;
```

| Field       | Type         | Null | Key | Default | Extra |
| ----------- | ------------ | ---- | --- | ------- | ----- |
| emp_id      | int          | NO   | PRI | NULL    |       |
| emp_name    | varchar(100) | NO   |     | NULL    |       |
| email       | varchar(100) | NO   |     | NULL    |       |
| birth_date  | date         | NO   |     | NULL    |       |
| gender      | varchar(6)   | YES  |     | NULL    |       |
| dept_no     | int          | NO   | MUL | NULL    |       |
| address     | varchar(100) | YES  |     | NULL    |       |
| designation | varchar(10)  | YES  |     | NULL    |       |
| salary      | int          | YES  |     | NULL    |       |
| experience  | int          | YES  |     | NULL    |       |

**4. Insert proper data (at least 5 appropriate records) in all the tables.**

```sql
INSERT INTO Department VALUES
(10, 'Account', 'NY'),
(20, 'HR', 'NY'),
(30, 'Production', 'DL'),
(40, 'Sales', 'NY'),
(50, 'EDP', 'MU'),
(60, 'TRG', NULL),
(110, 'RND', 'AH');

INSERT INTO Employee VALUES
(1, 'Bhargav', 'bhargav@gmail.com', '2001-04-02', 'Male', 10, 'Deesa', 'manager', 40000, 7),
(2, 'Krunal', 'krunal@gmail.com', '2003-02-12', 'Male', 40, 'Sherpura, Deesa', 'analyst', 34000, 5),
(3, 'Neha', 'neha@gmail.com', '1999-08-15', 'Female', 20, 'Palanpur', 'designer', 30000, 9),
(4, 'Rahul', 'rahul@gmail.com', '1998-11-20', 'Male', 30, 'Ahmedabad', 'coder', 45000, 7),
(5, 'Priya', 'priya@gmail.com', '2000-05-10', 'Female', 10, 'Mehsana', 'tester', 28000, 6),
(6, 'Amit', 'amit@gmail.com', '1997-01-25', 'Male', 50, 'Gandhinagar', 'leader', 55000, 7),
(7, 'Sneha', 'sneha@gmail.com', '2002-09-18', 'Female', 40, 'Deesa', 'clerk', 22000, 4),
(8, 'Vikas', 'vikas@gmail.com', '1996-12-05', 'Male', 60, 'Patan', 'analyst', 37000, 7),
(9, 'Riya', 'riya@gmail.com', '2001-03-22', 'Female', 20, 'Unjha', 'designer', 32000, 5),
(10, 'Suresh', 'suresh@gmail.com', '1995-07-14', 'Male', 30, 'Visnagar', 'manager', 60000, 8);
```

**5. Describe the structure of table created**

```sql
DESCRIBE Department;
```

| Field     | Type         | Null | Key | Default | Extra |
| --------- | ------------ | ---- | --- | ------- | ----- |
| dept_no   | int          | NO   | PRI | NULL    |       |
| dept_name | varchar(100) | NO   | UNI | NULL    |       |
| location  | varchar(100) | YES  |     | NULL    |       |

**6. List all records of each table in ascending order.**

```sql
SELECT * FROM Department ORDER BY dept_no;
```

| dept_no | dept_name  | location |
| ------- | ---------- | -------- |
| 10      | Account    | NY       |
| 20      | HR         | NY       |
| 30      | Production | DL       |
| 40      | Sales      | NY       |
| 50      | EDP        | MU       |
| 60      | TRG        | NULL     |
| 110     | RND        | AH       |

```sql
SELECT * FROM Employee ORDER BY emp_id;
```

| emp_id | emp_name | email             | birth_date | gender | dept_no | address         | designation | salary | experience |
| ------ | -------- | ----------------- | ---------- | ------ | ------- | --------------- | ----------- | ------ | ---------- |
| 1      | Bhargav  | bhargav@gmail.com | 2001-04-02 | Male   | 10      | Deesa           | manager     | 40000  | 7          |
| 2      | Krunal   | krunal@gmail.com  | 2003-02-12 | Male   | 40      | Sherpura, Deesa | analyst     | 34000  | 5          |
| 3      | Neha     | neha@gmail.com    | 1999-08-15 | Female | 20      | Palanpur        | designer    | 30000  | 9          |
| 4      | Rahul    | rahul@gmail.com   | 1998-11-20 | Male   | 30      | Ahmedabad       | coder       | 45000  | 7          |
| 5      | Priya    | priya@gmail.com   | 2000-05-10 | Female | 10      | Mehsana         | tester      | 28000  | 6          |
| 6      | Amit     | amit@gmail.com    | 1997-01-25 | Male   | 50      | Gandhinagar     | leader      | 55000  | 7          |
| 7      | Sneha    | sneha@gmail.com   | 2002-09-18 | Female | 40      | Deesa           | clerk       | 22000  | 4          |
| 8      | Vikas    | vikas@gmail.com   | 1996-12-05 | Male   | 60      | Patan           | analyst     | 37000  | 7          |
| 9      | Riya     | riya@gmail.com    | 2001-03-22 | Female | 20      | Unjha           | designer    | 32000  | 5          |
| 10     | Suresh   | suresh@gmail.com  | 1995-07-14 | Male   | 30      | Visnagar        | manager     | 60000  | 8          |

**7. Delete the department whose loction is Ahmedabad.**

```sql
DELETE FROM Department WHERE location = 'AH';
```

**8. Display female employee list**

```sql
SELECT * FROM Employee WHERE gender='Female';
```

| emp_id | emp_name | email           | birth_date | gender | dept_no | address  | designation | salary | experience |
| ------ | -------- | --------------- | ---------- | ------ | ------- | -------- | ----------- | ------ | ---------- |
| 3      | Neha     | neha@gmail.com  | 1999-08-15 | Female | 20      | Palanpur | designer    | 30000  | 9          |
| 5      | Priya    | priya@gmail.com | 2000-05-10 | Female | 10      | Mehsana  | tester      | 28000  | 6          |
| 7      | Sneha    | sneha@gmail.com | 2002-09-18 | Female | 40      | Deesa    | clerk       | 22000  | 4          |
| 9      | Riya     | riya@gmail.com  | 2001-03-22 | Female | 20      | Unjha    | designer    | 32000  | 5          |

**9. Display Departname wise employee Names**

```sql
SELECT dept_name, emp_name FROM Employee NATURAL JOIN Department ORDER BY dept_no;
```

| dept_name  | emp_name |
| ---------- | -------- |
| Account    | Bhargav  |
| Account    | Priya    |
| HR         | Neha     |
| HR         | Riya     |
| Production | Rahul    |
| Production | Suresh   |
| Sales      | Krunal   |
| Sales      | Sneha    |
| EDP        | Amit     |
| TRG        | Vikas    |

**showing total employees in each department**

```sql
SELECT dept_name, COUNT(emp_name) AS NOofEMPs FROM Employee NATURAL JOIN Department GROUP BY dept_no;
```

| dept_name  | NOofEMPs |
| ---------- | -------- |
| Account    | 2        |
| EDP        | 1        |
| HR         | 2        |
| Production | 2        |
| Sales      | 2        |
| TRG        | 1        |

**10. Find the names of the employee who has salary less than 5000 and greater than 2000.**

```sql
SELECT emp_id from Employee WHERE salary < 5000 AND salary > 2000;
```

**Not any record**

**11. Display the names and the designation of all female employee in descending order.**

```sql
SELECT emp_name, designation FROM Employee WHERE gender='Female' ORDER BY emp_name DESC;
```

| emp_name | designation |
| -------- | ----------- |
| Sneha    | clerk       |
| Riya     | designer    |
| Priya    | tester      |
| Neha     | designer    |

**12. Display the names of all the employees who names starts with 'A' ends with 'A'.**

```sql
SELECT * FROM Employee WHERE emp_name LIKE 'A%A';
```

**Not any record**

**13. Find the name of employee and salary for those who had obtain minimum salary.**

```sql
SELECT emp_name, salary FROM Employee ORDER BY salary LIMIT 2;
```

| emp_name | salary |
| -------- | ------ |
| Sneha    | 22000  |
| Priya    | 28000  |

**average salary**

```sql
SELECT AVG(salary) AS AverageSalary FROM Employee;
```

| AverageSalary |
| ------------- |
| 38300.0000    |

**showing how has less then average**

```sql
SELECT emp_name, salary FROM Employee
  WHERE salary < (SELECT AVG(salary) FROM Employee)
  ORDER BY salary;
```

| emp_name | salary |
| -------- | ------ |
| Sneha    | 22000  |
| Priya    | 28000  |
| Neha     | 30000  |
| Riya     | 32000  |
| Krunal   | 34000  |
| Vikas    | 37000  |

**14. Add 10% raise in salary of all employees whose department is 'IT'.**

```sql
UPDATE Employee SET salary=salary+(salary*0.1) WHERE dept_no = (
  SELECT dept_no FROM Department WHERE dept_name = 'IT'
);
```

**15. Count total number of employees of 'IT' department.**

```sql
SELECT COUNT(emp_id) AS EMPinITDept FROM Employee WHERE dept_no = (
  SELECT dept_no FROM Department WHERE dept_name = 'IT'
);
```

**Not any result: Department 'IT' is not present in department**

**16. List all employees who born in the current month.**

```sql
SELECT * FROM Employee WHERE MONTH(CURDATE()) = MONTH(birth_date);
```

| emp_id | emp_name | email          | birth_date | gender | dept_no | address     | designation | salary | experience |
| ------ | -------- | -------------- | ---------- | ------ | ------- | ----------- | ----------- | ------ | ---------- |
| 6      | Amit     | amit@gmail.com | 1997-01-25 | Male   | 50      | Gandhinagar | leader      | 55000  | 7          |

**17. Print the record of employee and dept table as "Employee works in department 'MBA'.**

```sql
SELECT * FROM Employee NATURAL JOIN Department WHERE dept_name = 'MBA';
```

**No result**

**18. List names of employees who are fresher's (less than 1 year of experience).**

```sql
SELECT * FROM Employee WHERE experience < 1;
```

**No record like that**

**19. List department wise names of employees who has more than 5 years of experience.**

```sql
SELECT dept_no, emp_name FROM Employee WHERE experience > 5 ORDER BY dept_no;
```

| dept_no | emp_name |
| ------- | -------- |
| 10      | Bhargav  |
| 10      | Priya    |
| 20      | Neha     |
| 30      | Rahul    |
| 30      | Suresh   |
| 50      | Amit     |
| 60      | Vikas    |

**20. Create Sequence to generate department ID**

```sql
-- SEQUENCE is not support in mysql, using auto_increment is one of best option that i get
-- Oracle sequence example
CREATE SEQUENCE department_id_seq
START WITH 1
INCREMENT BY 1
MINVALUE 1
NOMAXVALUE
NOCYCLE
CACHE 20;
```

**21. List department having no employees**

```sql
-- test record
INSERT INTO Department (dept_no, dept_name, location)
VALUES (222, 'Marketing', 'Mumbai');

SELECT * FROM Department WHERE dept_no NOT IN (
  SELECT dept_no FROM Employee
);
```

| dept_no | dept_name | location |
| ------- | --------- | -------- |
| 110     | RND       | AH       |
| 222     | Marketing | Mumbai   |
