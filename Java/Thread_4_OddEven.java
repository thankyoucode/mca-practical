class myThread extends Thread {
  String name;
  int n;

  public myThread(String name, int n) {
    this.name = name;
    this.n = n;
  }

  public void run() {
    for (int i = n; i <= 50; i += 2) {
      System.out.print(name + " - " + i + "\t");
    }
  }
}

public class Thread_4_OddEven {
  public static void main(String args[]) {
    myThread odd = new myThread("odd ", 1);
    myThread even = new myThread("even", 2);
    odd.start();
    even.start();
  }
}