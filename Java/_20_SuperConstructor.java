abstract class Account {
  protected String account_no;
  protected int balance = 0;

  Account(String in_account_no, int in_balance) {
    account_no = in_account_no;
    balance = in_balance;
  }
}

class Current extends Account {
  Current(String in_account_no, int in_balance) {
    super(in_account_no, in_balance);
    account_no = in_account_no;
    balance = in_balance;
  }

  public void checkBalance() {
    System.out.println("Your Balance is: " + balance);
  }

  public int withdraw(int withdraw_amount) {
    if (balance >= withdraw_amount) {
      balance -= withdraw_amount;
      checkBalance();
      return withdraw_amount;
    } else {
      System.out.println("Not valid Amount");
      return 0;
    }
  }

  public void deposit(int credit_amount) {
    if (credit_amount > 0) {
      balance += credit_amount;
      checkBalance();
    }
  }
}

class Savings extends Current {
  private double interestRate;

  Savings(String in_account_no, int in_balance, double in_interestRate) {
    super(in_account_no, in_balance);
    interestRate = in_interestRate;
  }
}

public class _20_SuperConstructor {
  public static void main(String args[]) {
    Current current = new Current("1928349", 10000);
    Savings savings = new Savings("1928349", 10000, 30.40);
    current.deposit(500);
    savings.deposit(500);
  }
}