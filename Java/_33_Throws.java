// Write a small application in Java to develop Banking Application in which user deposits the
// amount Rs 1000.00 and then start withdrawing of Rs 400.00, Rs 300.00 and it throws exception
// "Not Sufficient Fund" when user withdraws Rs. 500 thereafter

class Bank {
  private int amount;

  public Bank(int amount) {
    this.amount = amount;
  }

  public void put(int amount) throws Exception {
    if(0 > amount) {
      this.amount += amount;
      System.out.println(amount + " Is added");
    } else {
      throw new Exception("Put Valid Amount Number");
    }
  }

  public void withdraw(int amount) throws Exception {
    if(this.amount > amount) {
      System.out.println(amount + " Is Withdraw");
      this.amount -= amount;
    } else {
      throw new Exception("Not Sufficient Fund");
    }
  }
}

public class _33_Throws {
  public static void main(String[] args) throws Exception {
    Bank myBank = new Bank(1000);
    myBank.withdraw(400);
    myBank.withdraw(300);
    myBank.withdraw(500);
  }
}
