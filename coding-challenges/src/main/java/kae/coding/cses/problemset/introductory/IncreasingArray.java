package kae.coding.cses.problemset.introductory;

/** <a href="https://cses.fi/problemset/task/1094/">https://cses.fi/problemset/task/1094/</a> */
public class IncreasingArray {
  public static long solve(int[] arr) {
    long k = 0;

    for (int i = 1; i < arr.length; i++) {
      int d = arr[i - 1] - arr[i];
      if (d <= 0) {
        continue;
      }
      k += d;
      arr[i] = arr[i - 1];
    }

    return k;
  }
}
