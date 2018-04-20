package kae.hello.concurrency;

public class HelloDeadlock {

  private static final Object LOCK1 = new Object();
  private static final Object LOCK2 = new Object();

  public static void main(String[] args) throws Exception {
    final Thread t1 = new Thread(() -> {
      synchronized (LOCK1) {
        System.out.println(Thread.currentThread().getName() + ": Acquired LOCK1");

        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        synchronized (LOCK2) {
          System.out.println(Thread.currentThread().getName() + ": Acquired LOCK2");
        }
        System.out.println(Thread.currentThread().getName() + ": Released LOCK2");
      }
      System.out.println(Thread.currentThread().getName() + ": Released LOCK1");
    }, "Thread 1");

    final Thread t2 = new Thread(() -> {
      synchronized (LOCK2) {
        System.out.println(Thread.currentThread().getName() + ": Acquired LOCK2");

        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        synchronized (LOCK1) {
          System.out.println(Thread.currentThread().getName() + ": Acquired LOCK1");
        }
        System.out.println(Thread.currentThread().getName() + ": Released LOCK1");
      }
      System.out.println(Thread.currentThread().getName() + ": Released LOCK2");
    }, "Thread 2");


    t1.start();
    t2.start();
    t1.join();
    t2.join();
  }

}
