package kae.hello.java8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class HelloCompletableFuture {

  public static void main(String[] args) {
    final Random random = new Random();
    final int maxSize = 20_000_000;
    final int[] numbers = IntStream.generate(() -> random.nextInt(maxSize)).limit(maxSize).toArray();

    List<CompletableFuture<Void>> futures = new LinkedList<>();
    final long startTime = System.currentTimeMillis();
    futures.add(sortAsync(numbers, Arrays::sort).thenRunAsync(() -> printDuration("Dual-Pivot Quicksort", startTime)));
    futures.add(sortAsync(numbers, HelloCompletableFuture::mergeSort).thenRunAsync(() -> printDuration("Merge sort", startTime)));

    for (CompletableFuture<Void> future : futures) {
      future.join();
    }
  }

  private static CompletableFuture<int[]> sortAsync(int[] numbers, Sorter sorter) {
    return CompletableFuture.supplyAsync(() -> sort(numbers, sorter));
  }

  private static int[] sort(int[] numbers, Sorter sorter) {
    final int[] copy = numbers.clone();
    sorter.sort(copy);
    return copy;
  }

  private static void printDuration(String sorterName, long startTime) {
    final long duration = System.currentTimeMillis() - startTime;
    System.out.println(sorterName + " done in " + duration + " ms.");
  }

  @FunctionalInterface
  private interface Sorter {
    void sort(int[] numbers);
  }

  public static void mergeSort(int[] a) {
    int[] tmp = new int[a.length];
    mergeSort(a, tmp, 0, a.length - 1);
  }


  private static void mergeSort(int[] a, int[] tmp, int left, int right) {
    if (left < right) {
      int center = (left + right) / 2;
      mergeSort(a, tmp, left, center);
      mergeSort(a, tmp, center + 1, right);
      merge(a, tmp, left, center + 1, right);
    }
  }


  private static void merge(int[] a, int[] tmp, int left, int right, int rightEnd) {
    int leftEnd = right - 1;
    int k = left;
    int num = rightEnd - left + 1;

    while (left <= leftEnd && right <= rightEnd)
      if (a[left] <= a[right])
        tmp[k++] = a[left++];
      else
        tmp[k++] = a[right++];

    while (left <= leftEnd)    // Copy rest of first half
      tmp[k++] = a[left++];

    while (right <= rightEnd)  // Copy rest of right half
      tmp[k++] = a[right++];

    // Copy tmp back
    for (int i = 0; i < num; i++, rightEnd--)
      a[rightEnd] = tmp[rightEnd];
  }

}
