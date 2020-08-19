package kae.study.codingchallenges.cses.problemset.introductory;

import java.util.Scanner;

/**
 * You are given all numbers between 1,2,…,n except one. Your task is to find the missing number.
 *
 * <p>Input
 *
 * <p>The first input line contains an integer n.
 *
 * <p>The second line contains n−1 numbers. Each number is distinct and between 1 and n (inclusive).
 *
 * <p>Output
 *
 * <p>Print the missing number.
 *
 * <p>Constraints 2≤n≤2⋅105
 */
public class MissingNumber {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();

    long sum = (long) n * (1 + n) / 2;

    for (int i = 1; i < n; ++i) {
      sum -= scanner.nextInt();
    }

    System.out.println(sum);
  }
}
