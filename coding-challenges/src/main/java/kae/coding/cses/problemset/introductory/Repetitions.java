package kae.coding.cses.problemset.introductory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * You are given a DNA sequence: a string consisting of characters A, C, G, and T. Your task is to
 * find the longest repetition in the sequence. This is a maximum-length substring containing only
 * one type of character.
 *
 * <p>Input: The only input line contains a string of n characters.
 *
 * <p>Output: Print one integer: the length of the longest repetition.
 *
 * <p>Constraints: 1≤n≤106
 *
 * <p>Example:
 *
 * <p>Input: ATTCGGGA
 *
 * <p>Output: 3
 */
public class Repetitions {

  public static void main(String[] args) throws Exception {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      String s = reader.readLine();
      int result = solve(s);
      System.out.println(result);
    }
  }

  private static int solve(String s) {
    if (s.isEmpty()) {
      return 0;
    }

    char[] chars = s.toCharArray();
    int max = 1;
    int counter = 1;

    for (int i = 1; i < chars.length; ++i) {
      if (chars[i] == chars[i - 1]) {
        counter++;
      } else {
        max = Math.max(max, counter);
        counter = 1;
      }
    }
    max = Math.max(max, counter);

    return max;
  }
}
