# SET - 8

**EMPMAST (empno, name, pfno, empbasic, deptno, designation), DEPT (DNO, DNAME)**

- Rules: HRA = 15% of basic
- DA = 50% of basic
- Medical = 100
- PF = 8.33%of basic
- Print Salary slip. Design your own format

```sql
DROP TABLE Department;
DROP TABLE Empmast;

CREATE TABLE Department (
  dno INT PRIMARY KEY,
  dname VARCHAR(25)
);


CREATE TABLE Empmast (
  empno INT PRIMARY KEY,
  name VARCHAR(25),
  basic_salary INT,
  pf FLOAT(2),
  post VARCHAR(25),
  dno INT,
  FOREIGN KEY (dno) REFERENCES Department(dno)
);


INSERT INTO Department values (101, 'Design');
INSERT INTO Department values (102, 'Development');
INSERT INTO Department values (103, 'Management');

INSERT INTO Empmast values (201, 'Sujal', 54000, 8.33, 'Figma-Designing', 101);
INSERT INTO Empmast values (202, 'Dilip', 64000, 8.33, 'Store-Management', 103);
INSERT INTO Empmast values (203, 'Suresh', 34000, 8.33, 'Html-Developer', 102);
INSERT INTO Empmast values (204, 'Suresh', 54000, 8.33, 'Django-Developer', 102);

SELECT * FROM Department;
SELECT * FROM Empmast;


DROP PROCEDURE IF EXISTS show_emp_salary_details;

DELIMITER //

CREATE PROCEDURE show_emp_salary_details()
BEGIN
  DECLARE done INT DEFAULT 0;

  DECLARE v_empno INT;
  DECLARE v_name VARCHAR(50);
  DECLARE v_basic_salary DECIMAL(10,2);

  DECLARE c1 CURSOR FOR
    SELECT empno, name, basic_salary
    FROM Empmast;

  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

  OPEN c1;

  read_loop: LOOP
    FETCH c1 INTO v_empno, v_name, v_basic_salary;
    IF done = 1 THEN
      LEAVE read_loop;
    END IF;

    SELECT
      CONCAT(
        'EMP NO: ', v_empno,
        ', EMP NAME: ', v_name,
        ', HRA: ', v_basic_salary * 0.15,
        ', DA: ', v_basic_salary * 0.50,
        ', Medical: ', 100,
        ', PF: ', v_basic_salary * 0.833
      ) AS Salary_Details;
  END LOOP;

  CLOSE c1;
END //

DELIMITER ;

-- Running procedure
CALL show_emp_salary_details();
```

| Salary_Details                                                                               |
| -------------------------------------------------------------------------------------------- |
| EMP NO: 201, EMP NAME: Sujal, HRA: 8100.0000, DA: 27000.0000, Medical: 100, PF: 44982.00000  |
| EMP NO: 202, EMP NAME: Dilip, HRA: 9600.0000, DA: 32000.0000, Medical: 100, PF: 53312.00000  |
| EMP NO: 203, EMP NAME: Suresh, HRA: 5100.0000, DA: 17000.0000, Medical: 100, PF: 28322.00000 |
| EMP NO: 204, EMP NAME: Suresh, HRA: 8100.0000, DA: 27000.0000, Medical: 100, PF: 44982.00000 |
