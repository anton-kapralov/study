package kae.coding.java.bignumber.bigdecimal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int n = scanner.nextInt();
    scanner.nextLine();
    final String[] numbers = new String[n];
    for (int i = 0; i < n; i++) {
      numbers[i] = scanner.nextLine();
    }

    Arrays.sort(
        numbers,
        new Comparator<String>() {
          @Override
          public int compare(String o1, String o2) {
            return -1 * new BigDecimal(o1).compareTo(new BigDecimal(o2));
          }
        });

    for (String number : numbers) {
      System.out.println(number);
    }
  }
}
