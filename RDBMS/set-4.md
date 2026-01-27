# SET - 4

**A. Write a PLSQL block which will print Employee list (Empno and Name)**

- EMP (empno, empnm, empadd, salary, date_birth, joindt, deptno)

```sql
CREATE TABLE Employee (
  empno INT PRIMARY KEY,
  name VARCHAR(50),
  address VARCHAR(100),
  salary INT,
  dob DATE,
  joindate DATE,
  department_no INT
);

INSERT INTO Employee VALUES
(1, 'Subham', 'Deesa, BK, Gujarat', 70000, '2005-01-10', '2014-01-01', 1001),
(2, 'Maher', 'Deesa, BK, Gujarat', 70000, '2005-01-10', '2014-01-01', 1001);

DELIMITER //

CREATE PROCEDURE show_employee_list()
BEGIN
DECLARE done INT DEFAULT 0;
DECLARE v_empno INT;
DECLARE v_name VARCHAR(50);

DECLARE cur_emp CURSOR FOR
SELECT empno, name FROM Employee;

DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

OPEN cur_emp;

read_loop: LOOP
  FETCH cur_emp INTO v_empno, v_name;
  IF done = 1 THEN
    LEAVE read_loop;
  END IF;
  SELECT CONCAT('Employee No: ', v_empno, ', Name: ', v_name) AS Employee_Info;
END LOOP;

CLOSE cur_emp;
END //

DELIMITER ;

CALL show_employee_list();
```

| Employee_Info                |
| ---------------------------- |
| Employee No: 1, Name: Subham |
| Employee No: 2, Name: Maher  |

**B. Write a function that returns total number of incomplete jobs, using table JOB (jobid, type_of_job,status)**

```sql
CREATE TABLE Job (
  id INT PRIMARY KEY,
  jobtype VARCHAR(25),
  status VARCHAR(25)
);

INSERT INTO Job values(1, 'ux-designer', 'working');
INSERT INTO Job values(2, 'Figma-desiner', 'padding');
INSERT INTO Job values(3, 'frontend-developer', 'working');
INSERT INTO Job values(4, 'backend-developer', 'padding');

SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER //

CREATE FUNCTION no_of_incomplete_job() RETURNS INT
BEGIN
  DECLARE incomplete_count INT DEFAULT 0;
  SELECT COUNT(*) INTO incomplete_count FROM Job WHERE status <> 'complete';
  RETURN incomplete_count;
END //

DELIMITER ;

SELECT no_of_incomplete_job() AS NO_OF_INCOMPLETE_JOBS;
```

| NO_OF_INCOMPLETE_JOBS |
| --------------------- |
| 4                     |

**C. Write a function which displays the number of items whose weight fall between a given ranges for a particular color using table ITEM (itemno, name, color, weight)**

```sql
CREATE TABLE Item (
  itemno INT PRIMARY KEY,
  name VARCHAR(50),
  color VARCHAR(25),
  weight FLOAT
);

INSERT INTO Item VALUES(1, 'Keyboard', 'Black', 0.3);
INSERT INTO Item VALUES(2, 'Phone', 'Gray-Dark', 0.1);
INSERT INTO Item VALUES(3, 'Mouse', 'Black', 0.08);
INSERT INTO Item VALUES(4, 'Table', 'Gray', 12);
INSERT INTO Item VALUES(5, 'Chair', 'Black', 5);

DELIMITER //
CREATE FUNCTION items_in_range_color(min_weight FLOAT, max_weight FLOAT, item_color VARCHAR(25))
RETURNS INT
READS SQL DATA
DETERMINISTIC
BEGIN
  DECLARE item_count INT DEFAULT 0;
  SELECT COUNT(*) INTO item_count
  FROM Item
  WHERE weight BETWEEN min_weight AND max_weight
  AND color = item_color;
  RETURN item_count;
END //

DELIMITER ;

SELECT items_in_range_color(1, 10, 'Black') AS NO_OF_ITEMS;
```

| NO_OF_ITEMS |
| ----------- |
| 1           |

**D. Write a procedure to display top five highest paid workers who are specialized in “PAINTING" using table WORKER (workerid, name, wage_per_hour, specialized_in, manager_id)**

- wage_per_hour - paid per hour

```sql
CREATE TABLE Worker (
  workerid INT PRIMARY KEY,
  name VARCHAR(50),
  wage_per_hour FLOAT,
  specialized_in VARCHAR(100),
  manager_id INT
);

INSERT INTO Worker VALUES
(1, 'Bhavesh', 460, 'UI Desiging', 102),
(2, 'Hitesh Chaudhary', 2200, 'Teaching', 222),
(3, 'Vidya', 1200, 'Thumbnail Designing', 2),
(4, 'Kishan Jat', 700, 'Painting', 2);

DELIMITER //
CREATE PROCEDURE show_top5_painters()
BEGIN
  SELECT * FROM Worker WHERE specialized_in = 'Painting' ORDER BY wage_per_hour DESC LIMIT 5;
END //
DELIMITER ;

CALL show_top5_painters();
```

| workerid | name       | wage_per_hour | specialized_in | manager_id |
| -------- | ---------- | ------------- | -------------- | ---------- |
| 4        | Kishan Jat | 700           | Painting       | 2          |
