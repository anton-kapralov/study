package kae.hello.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SequentialMultithreading {

  private static final int SIZE = 4;
  private static final int TIMES = 100;

  public static void main(String[] args) throws InterruptedException {
    Semaphore[] semaphores = new Semaphore[SIZE];
    for (int i = 0; i < SIZE; i++) {
      final Semaphore semaphore = new Semaphore(1);
      semaphores[i] = semaphore;
      semaphore.acquire();
    }

    final ExecutorService executorService = Executors.newFixedThreadPool(SIZE);

    for (int i = 0; i < SIZE; i++) {
      final String s = String.valueOf((char) ('a' + i));
      final Semaphore semaphore = semaphores[i];
      final Semaphore nextSemaphore = i + 1 < SIZE ? semaphores[i + 1] : semaphores[0];
      executorService.submit(new Worker(s, TIMES, semaphore, nextSemaphore));
    }

    semaphores[0].release();

    executorService.shutdown();
    executorService.awaitTermination(1, TimeUnit.MINUTES);
  }

  static class Worker implements Runnable {

    private final String s;
    private final int times;
    private final Semaphore semaphore;
    private final Semaphore nextSemaphore;

    Worker(String s, int times, Semaphore semaphore, Semaphore nextSemaphore) {
      this.s = s;
      this.times = times;
      this.semaphore = semaphore;
      this.nextSemaphore = nextSemaphore;
    }

    @Override
    public void run() {
      try {
        for (int i = 0; i < times; i++) {
          semaphore.acquire();
          System.out.print(s);
          nextSemaphore.release();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
        Thread.interrupted();
      }
    }
  }

}
