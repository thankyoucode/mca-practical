# SET - 1

## DEPARTMENT (dept_no, dept_name, location)

**1. Create the Simple DEPARTMENT Table.**

```sql
CREATE TABLE Department (
  dept_no INT,
  dept_name VARCHAR(100) NOT NULL UNIQUE,
  location VARCHAR(2)
);
```

**2. Display structure of department table.**

```sql
DESCRIBE Department;
```

| Field     | Type         | Null | Key | Default | Extra |
| --------- | ------------ | ---- | --- | ------- | ----- |
| dept_no   | int          | YES  |     | NULL    |       |
| dept_name | varchar(100) | NO   | PRI | NULL    |       |
| location  | varchar(2)   | YES  |     | NULL    |       |

**3. Insert below records into Department Table**

| Dept_no | Dept_name  | Location |
| ------- | ---------- | -------- |
| 10      | Account    | NY       |
| 20      | HR         | NY       |
| 30      | Production | DL       |
| 40      | Sales      | NY       |
| 50      | EDP        | MU       |
| 60      | TRG        |          |
| 110     | RND        | AH       |

```sql
INSERT INTO Department VALUES
(10, 'Account', 'NY'),
(20, 'HR', 'NY'),
(30, 'Production', 'DL'),
(40, 'Sales', 'NY'),
(50, 'EDP', 'MU'),
(60, 'TRG', NULL),
(110, 'RND', 'AH');
```

**4. Display all records of Department table**

```sql
SELECT * FROM Department;
```

| dept_no | dept_name  | location |
| ------- | ---------- | -------- |
| 10      | Account    | NY       |
| 50      | EDP        | MU       |
| 20      | HR         | NY       |
| 30      | Production | DL       |
| 110     | RND        | AH       |
| 40      | Sales      | NY       |
| 60      | TRG        | NULL     |

**5. Display all department belonging to location 'NY'**

```sql
SELECT * FROM Department WHERE location = 'NY';
```

| dept_no | dept_name | location |
| ------- | --------- | -------- |
| 10      | Account   | NY       |
| 20      | HR        | NY       |
| 40      | Sales     | NY       |

**6. Display details of Department 10**

```sql
SELECT * FROM Department WHERE dept_no = 10;
```

| dept_no | dept_name | location |
| ------- | --------- | -------- |
| 10      | Account   | NY       |

**7. List all department names starting with 'A'**

```sql
SELECT * FROM Department WHERE dept_name LIKE 'A%';
```

| dept_no | dept_name | location |
| ------- | --------- | -------- |
| 10      | Account   | NY       |

**8. List all departments whose number is between 1 and 100**

```sql
SELECT * FROM Department WHERE dept_no BETWEEN 1 and 100;
```

| dept_no | dept_name  | location |
| ------- | ---------- | -------- |
| 10      | Account    | NY       |
| 50      | EDP        | MU       |
| 20      | HR         | NY       |
| 30      | Production | DL       |
| 40      | Sales      | NY       |
| 60      | TRG        | NULL     |

**9. Delete 'TRG' department**

```sql
DELETE FROM Department WHERE dept_name = 'TRG';
```

| dept_no | dept_name  | location |
| ------- | ---------- | -------- |
| 10      | Account    | NY       |
| 50      | EDP        | MU       |
| 20      | HR         | NY       |
| 30      | Production | DL       |
| 110     | RND        | AH       |
| 40      | Sales      | NY       |

**10. Change department name 'EDP' to 'IT**

```sql
UPDATE Department SET dept_name='IT' WHERE dept_name='EDP';
```

| dept_no | dept_name  | location |
| ------- | ---------- | -------- |
| 10      | Account    | NY       |
| 20      | HR         | NY       |
| 50      | IT         | MU       |
| 30      | Production | DL       |
| 110     | RND        | AH       |
| 40      | Sales      | NY       |
