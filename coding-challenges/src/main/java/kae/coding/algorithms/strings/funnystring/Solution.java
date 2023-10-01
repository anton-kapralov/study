package kae.coding.algorithms.strings.funnystring;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int T = scanner.nextInt();
    scanner.nextLine();
    for (int i = 0; i < T; i++) {
      final String s = scanner.nextLine();
      System.out.println(test(s) ? "Funny" : "Not Funny");
    }
  }

  private static boolean test(String s) {
    final int length = s.length();

    for (int i = 1; i < length; i++) {
      if (Math.abs(s.charAt(i) - s.charAt(i - 1))
          != Math.abs(s.charAt(length - i) - s.charAt(length - i - 1))) {
        return false;
      }
    }

    return true;
  }
}
