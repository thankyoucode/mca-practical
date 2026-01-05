class Account {
  public static int amount = 0;

  public static synchronized void putMoney(int amount) {
    Account.amount += amount;
  }

  public static synchronized void getMoney(int amount) {
    if (Account.amount < amount) {
      System.out.println("You have not this much amount");
      return;
    }
    Account.amount -= amount;
  }
}

class myThread extends Thread {
  String name;

  public myThread(String name) {
    this.name = name;
  }

  public void run() {
    for (int i = 0; i < 3; i++) {
      Account.getMoney(i);
      System.out.print(name + "-" + Account.amount + "\t");
    }
  }
}

public class Thread_6_sync {
  public static void main(String args[]) {
    myThread a = new myThread("A");
    myThread b = new myThread("B");
    myThread c = new myThread("C");
    Account.putMoney(5);
    a.start();
    b.start();
    c.start();
    System.out.println("You have this much amount: " + Account.amount);
  }
}