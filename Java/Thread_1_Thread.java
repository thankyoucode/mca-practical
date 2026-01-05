class myThread extends Thread {
  String name;
  public myThread(String name) { this.name = name;  }
  public void run() {
    long fact = 1;
    for(long n = 5; n > 0; n--){
      fact *= n;
      System.out.print(name + "-" + fact + "\t");
    }
  }
}
public class Thread_1_Thread {
  public static void main(String args[]) {
    myThread t1 = new myThread("t1");
    myThread t2 = new myThread("t2");
    t1.start();
    t2.start();
  }
}