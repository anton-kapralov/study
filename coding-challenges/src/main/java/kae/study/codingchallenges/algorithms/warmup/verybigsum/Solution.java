package kae.study.codingchallenges.algorithms.warmup.verybigsum;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int n = scanner.nextInt();
    BigInteger sum = BigInteger.ZERO;
    for (int i = 0; i < n; i++) {
      sum = sum.add(scanner.nextBigInteger());
    }
    System.out.println(sum);
  }

}
