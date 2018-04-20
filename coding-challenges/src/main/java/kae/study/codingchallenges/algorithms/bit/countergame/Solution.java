package kae.study.codingchallenges.algorithms.bit.countergame;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i < t; i++) {
      BigInteger n = new BigInteger(scanner.nextLine());
      play(n);
    }
  }

  private static void play(BigInteger n) {
    int turn = 0;
    while (n.compareTo(BigInteger.ONE) > 0) {
      ++turn;
      if (isPowerOf2(n)) {
        n = n.shiftRight(1);
      } else {
        int highestOneBit = getHighestOneBit(n);
        n = n.clearBit(highestOneBit);
      }
    }

    if ((turn & 1) != 0) {
      System.out.println("Louise");
    } else {
      System.out.println("Richard");
    }
  }

  private static boolean isPowerOf2(BigInteger n) {
    return n.and(n.subtract(BigInteger.ONE)).equals(BigInteger.ZERO);
  }

  // Rewrite with bitwise operations |= and >>.
  private static int getHighestOneBit(BigInteger n) {
    int i = 0;
    int highest = -1;
    BigInteger mask = BigInteger.ONE;
    while (mask.compareTo(n) < 0) {
      if (n.and(mask).compareTo(BigInteger.ZERO) != 0) {
        highest = i;
      }
      mask = mask.shiftLeft(1);
      ++i;
    }

    return highest;
  }

}
