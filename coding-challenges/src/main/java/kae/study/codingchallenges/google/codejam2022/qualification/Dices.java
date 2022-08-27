package kae.study.codingchallenges.google.codejam2022.qualification;

import java.util.Arrays;
import java.util.Scanner;

/**
 * While the most typical type of dice have 6 sides, each of which shows a different integer 1
 * through 6, there are many games that use other types. In particular, a dk is a die with k sides,
 * each of which shows a different integer 1 through k. A d6 is a typical die, a d4 has four sides,
 * and a d1000000 has one million sides.
 * <p>
 * Dice from sample case 1
 * <p>
 * In this problem, we start with a collection of N dice. The i-th die is a dSi, that is, it has Si
 * sides showing integers 1 through Si. A straight of length ℓ starting at x is the list of
 * integers x,x+1,…,x+(ℓ−1). We want to choose some of the dice (possibly all) and pick one number
 * from each to form a straight. What is the longest straight we can form in this way?
 */
public class Dices {

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int T = in.nextInt();

      for (int t = 1; t <= T; ++t) {
        int n = in.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
          input[i] = in.nextInt();
        }

        int output = solve(input);
        System.out.printf("Case #%d: %d\n", t, output);
      }
    }
  }

  static int solve(int[] input) {
    Arrays.sort(input);
    int c = 0;
    for (int i = 0; i < input.length; i++) {
      int k = input[i];
      if (c >= k) {
        continue;
      }
      c++;
    }
    return c;
  }

}
