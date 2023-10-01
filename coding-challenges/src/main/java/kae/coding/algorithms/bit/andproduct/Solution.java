package kae.coding.algorithms.bit.andproduct;

import java.util.Scanner;

/** */
public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Integer count = Integer.valueOf(scanner.nextLine());
    for (int i = 0; i < count; i++) {
      long a = scanner.nextLong();
      long b = scanner.nextLong();
      long result = compute(a, b);
      System.out.println(result);
    }
  }

  private static long compute(long a, long b) {
    if (isPowerOf2(a)) {
      return a;
    }

    long result = a;
    for (long i = a + 1; i <= b; ++i) {
      result &= i;
    }
    return result;
  }

  private static boolean isPowerOf2(long n) {
    return (n & (n - 1)) == 0;
  }
}
