public class threading {
  public static void main(String[] args) throws InterruptedException {
    MyThread t1 = new MyThread();
    MyThread t2 = new MyThread();
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println(MyThread.count);

  }
}

class MyThread extends Thread {
  static int count = 0;

  @Override
  public void run() {
    for (int i = 0; i < 1000000; i++) {
      increment();
    }
  }

  public static synchronized void increment() {
    count++;
  }
}
