package kae.study.codingchallenges.java.strings.strings;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    int substringLength = in.nextInt();

    String min = null;
    String max = null;
    int end = s.length() - substringLength;
    for (int i = 0; i <= end; i++) {
      String candidate = s.substring(i, i + substringLength);

      if (min == null || min.compareTo(candidate) > 0) {
        min = candidate;
      }

      if (max == null || max.compareTo(candidate) < 0) {
        max = candidate;
      }
    }

    System.out.println(min);
    System.out.println(max);
  }

}
