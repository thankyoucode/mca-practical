class myThread extends Thread {
  String name;
  int n;

  public myThread(String name, int n) {
    this.name = name;
    this.n = n;
  }

  public void run() {
    for (int i = 1; i <= n; i++) {
      System.out.print(name + "-" + i + "\t");
    }
  }
}

public class Thread_5_ABC {
  public static void main(String args[]) {
    myThread a = new myThread("A", 20);
    myThread b = new myThread("B", 30);
    myThread c = new myThread("C", 15);
    a.start();
    b.start();
    c.start();
  }
}