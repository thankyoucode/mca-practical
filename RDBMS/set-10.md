# SET - 10

**Employee (eid, fname, lname, salary)**

```sql
CREATE TABLE Employee (
  eid INT PRIMARY KEY,
  fname VARCHAR(25) NOT NULL,
  Lname VARCHAR(25),
  salary INT
);

INSERT INTO Employee VALUES
(1, 'Suajal', 'Mekwan', 52000),
(2, 'Kishan', 'Jat', 52000),
(3, 'Raju', 'Takarvadiya', 53000),
(4, 'Darshan', 'Takarvadiya', 53000),
(5, 'Jaimin', 'Purohit', 59000),
(6, 'Naresh', 'Chaudhary', 45000),
(7, 'Vishakha', 'Berwal', 30000),
(8, 'Kinjal', 'Makwana', 44000),
(9, 'Prachi', 'Soni', 44000),
(10, 'Vidhi', 'Patel', 38000),
(11, 'Suresh', 'Bochiya', 80000),
(12, 'Jyoti', 'Kumavat',  80000),
(13, 'Mahipal', 'Chavada', 42000),
(14, 'Bhavesh', 'Mali', 41000),
(15, 'Jayesh', 'Prajapati', 42000),
(16, 'Vishal', 'Prajapati', 43000),
(17, 'Vijay', 'Vadhela', 44000);
```

**1. Use a Cursor for Loop inside a function to calculate and return total paid salary to all employees by the company.**

```sql
DELIMITER //

CREATE FUNCTION return_total_paid_salary()
RETURNS INT
DETERMINISTIC
BEGIN
  DECLARE total_salary INT DEFAULT 0;
  DECLARE a_salary INT;
  DECLARE done INT DEFAULT 0;

  -- Declare cursor
  DECLARE cur_salary CURSOR FOR
    SELECT salary FROM Employee;

  -- Handler for end of cursor
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

  OPEN cur_salary;

  read_loop: LOOP
    FETCH cur_salary INTO a_salary;
    IF done = 1 THEN
      LEAVE read_loop;
    END IF;

    SET total_salary = total_salary + a_salary;
  END LOOP;

  CLOSE cur_salary;

  RETURN total_salary;
END;
//

DELIMITER ;

-- calling function
SELECT return_total_paid_salary();
```

| return_total_paid_salary() |
| -------------------------- |
| 842000                     |

**2. Modify the function created above to become a procedure and display the total paid salary from the procedure itself.**

- Instead of calculating for all employees, calculate only for those employees whose name starts from a character passed as parameter to the procedure and hence to the cursor.

```sql
DROP PROCEDURE IF EXISTS total_paid_salary;

DELIMITER //

CREATE PROCEDURE total_paid_salary(start_char CHAR(1))
BEGIN
  DECLARE total_salary INT DEFAULT 0;
  DECLARE a_salary INT;
  DECLARE done INT DEFAULT 0;
  DECLARE cur_salary CURSOR FOR
    SELECT salary FROM Employee
    WHERE fname LIKE CONCAT(start_char, '%');
  -- Handler for end of cursor
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
  OPEN cur_salary;
  read_loop: LOOP
    FETCH cur_salary INTO a_salary;
    IF done = 1 THEN
      LEAVE read_loop;
    END IF;
    SET total_salary = total_salary + a_salary;
  END LOOP;
  CLOSE cur_salary;
  SELECT CONCAT('Total paid salary for employees starting with "', start_char, '" = ', total_salary) AS Total_Salary;
END //

DELIMITER ;

CALL total_paid_salary('K');
```

| Total_Salary                                              |
| --------------------------------------------------------- |
| Total paid salary for employees starting with "K" = 96000 |
