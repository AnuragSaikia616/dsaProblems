
public class learn {

  public static void main(String[] args) throws InterruptedException {
    MyThread t1 = new MyThread();
    YourThread t2 = new YourThread();
    // t1.setDaemon(true);
    t2.start();
    // t2.join();
    t1.start();
    while (true) {
      System.out.println("hello");
    }

  }
}

class MyThread extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(this.getName() + ":" + i);
      try {
        Thread.sleep(400);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println(this.getClass().getName() + " has finished");
  }
}

class YourThread extends Thread {
  @Override
  public void run() {
    for (int i = 9; i >= 0; i--) {
      System.out.println(this.getName() + ":" + i);
      try {
        Thread.sleep(400);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      if (i == 5) {
        i = i / 0;
      }

    }
    System.out.println(this.getClass().getName() + " has finished");
  }
}
