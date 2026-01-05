class myThread extends Thread {
  String name;
  int time_gap;
  long n;

  public myThread(String name, int time_gap, long n) {
    this.name = name;
    this.time_gap = time_gap;
    this.n = n;
  }

  public void run() {
    for (int i = 1; i < n; i++) {
      try {
        Thread.sleep(time_gap);
      } catch (Exception e) {
      }
      System.out.print(name + "\t");
    }
  }
}

public class Thread_3_GapTime {
  public static void main(String args[]) {
    myThread t1 = new myThread("t1", 2000, 5);
    myThread t2 = new myThread("t2", 4000, 3);
    t1.start();
    t2.start();
  }
}