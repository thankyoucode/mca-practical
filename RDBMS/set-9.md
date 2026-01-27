# SET - 9

**Consider the Bank schema ACCOUNT, TRANSACTION**

ACCOUNT (AC_NO, NAME, AC_TYPE, BALANCE_AMT, BALANCE_DATE)

- Note: 1. AC_type may be S for saving or C for current.

```sql
CREATE TABLE Account (
  acno INT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  actype CHAR(1) CHECK (actype in ('S', 'C')) NOT NULL,
  balance INT DEFAULT 0,
  balancedate DATE
);
```

- creating 3 account with 0 balance

```sql
INSERT INTO Account (acno, name, actype)
VALUES
(101, 'Kishan', 'S'),
(102, 'Janak', 'C'),
(103, 'Krunal', 'S');
```

TRANSACTION (AC_NO, DATE, TR_TYPE, AMOUNT, PREV_BALANCE, REMARK)

- Note: 2. TR_type may be D for deposit or W for withdrawal.

```sql
CREATE TABLE Transactions (
  trno INT PRIMARY KEY AUTO_INCREMENT,
  acno INT,
  trtype CHAR CHECK (trtype in ('D', 'W')) NOT NULL,
  amount INT NOT NULL CHECK (amount > 0), -- amount can not be 0 or negative
  prevbalance INT,
  remark VARCHAR(255),
  trdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (acno) REFERENCES Account(acno)
);
```

- Creating a trigger that execute before transaction
- that set prevbalance from Account
- and update date in account - balancedate to last transaction date

```sql
DELIMITER //

CREATE TRIGGER trg_before_transaction
BEFORE INSERT ON Transactions
FOR EACH ROW
BEGIN
  DECLARE curr_balance INT;

  -- getting current balance from account
  SELECT balance INTO curr_balance
  FROM Account
  WHERE acno = NEW.acno;

  SET NEW.prevbalance = curr_balance;

  -- if withdrawal is more then account then show error with message and stop transaction (insertion)
  IF NEW.trtype = 'W' AND curr_balance < NEW.amount THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Insufficient balance';
  END IF;

  -- make operation based on D or W then update account balance and last balancedate to current transaction
  IF NEW.trtype = 'D' THEN
    UPDATE Account
    SET balance = balance + NEW.amount,
      balancedate = NEW.trdate
    WHERE acno = NEW.acno;
  ELSEIF NEW.trtype = 'W' THEN
    UPDATE Account
    SET balance = balance - NEW.amount,
      balancedate = NEW.trdate
    WHERE acno = NEW.acno;
  END IF;
END //

DELIMITER ;

-- Account 101 (Kishan)
-- Deposit 5000
INSERT INTO Transactions (acno, trtype, amount, remark)
VALUES (101, 'D', 5000, 'Initial deposit');

-- Withdraw 2000
INSERT INTO Transactions (acno, trtype, amount, remark)
VALUES (101, 'W', 2000, 'ATM withdrawal');

-- Account 102 (Janak)
-- Deposit 10000
INSERT INTO Transactions (acno, trtype, amount, remark)
VALUES (102, 'D', 10000, 'Salary deposit');

-- Withdraw 3000
INSERT INTO Transactions (acno, trtype, amount, remark)
VALUES (102, 'W', 3000, 'Bill payment');


-- Account 101 (Krunal)
-- Deposit 7000
INSERT INTO Transactions (acno, trtype, amount, remark)
VALUES (103, 'D', 7000, 'Initial deposit');

-- Withdraw 1000
INSERT INTO Transactions (acno, trtype, amount, remark)
VALUES (103, 'W', 1000, 'Grocery shopping');
```

Account after all transaction

| acno | name   | actype | balance | balancedate |
| ---- | ------ | ------ | ------- | ----------- |
| 101  | Kishan | S      | 3000    | 2026-01-26  |
| 102  | Janak  | C      | 7000    | 2026-01-26  |
| 103  | Krunal | S      | 6000    | 2026-01-26  |

Transactions after all transaction

| trno | acno | trtype | amount | prevbalance | remark           | trdate              |
| ---- | ---- | ------ | ------ | ----------- | ---------------- | ------------------- |
| 7    | 101  | D      | 5000   | 0           | Initial deposit  | 2026-01-26 19:19:56 |
| 8    | 101  | W      | 2000   | 5000        | ATM withdrawal   | 2026-01-26 19:19:56 |
| 9    | 102  | D      | 10000  | 0           | Salary deposit   | 2026-01-26 19:19:57 |
| 10   | 102  | W      | 3000   | 10000       | Bill payment     | 2026-01-26 19:19:57 |
| 11   | 103  | D      | 7000   | 0           | Initial deposit  | 2026-01-26 19:19:57 |
| 12   | 103  | W      | 1000   | 7000        | Grocery shopping | 2026-01-26 19:19:57 |

**a. Write a procedure to print the Bank Transaction details by passing from and to dates.**

```sql
DROP PROCEDURE IF EXISTS show_transaction_from_date_to_date;

DELIMITER //

CREATE PROCEDURE show_transaction_from_date_to_date(sdate DATE, edate DATE)
BEGIN
  SELECT *
  FROM Transactions
  WHERE trdate BETWEEN sdate AND edate;
END //

DELIMITER ;

CALL show_transaction_from_date_to_date('2026-01-01', '2026-02-01')
```

| trno | acno | trtype | amount | prevbalance | remark           | trdate              |
| ---- | ---- | ------ | ------ | ----------- | ---------------- | ------------------- |
| 7    | 101  | D      | 5000   | 0           | Initial deposit  | 2026-01-26 19:19:56 |
| 8    | 101  | W      | 2000   | 5000        | ATM withdrawal   | 2026-01-26 19:19:56 |
| 9    | 102  | D      | 10000  | 0           | Salary deposit   | 2026-01-26 19:19:57 |
| 10   | 102  | W      | 3000   | 10000       | Bill payment     | 2026-01-26 19:19:57 |
| 11   | 103  | D      | 7000   | 0           | Initial deposit  | 2026-01-26 19:19:57 |
| 12   | 103  | W      | 1000   | 7000        | Grocery shopping | 2026-01-26 19:19:57 |
