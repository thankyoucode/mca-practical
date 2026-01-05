class myThread implements Runnable {
  String name;

  public myThread(String name) {
    this.name = name;
  }

  public void run() {
    long fact = 1;
    for (long n = 5; n > 0; n--) {
      fact *= n;
      System.out.print(name + "-" + fact + "\t");
    }
  }
}

public class Thread_2_Runable {
  public static void main(String args[]) {
    Thread t1 = new Thread(new myThread("t1"));
    Thread t2 = new Thread(new myThread("t2"));
    t1.start();
    t2.start();
  }
}