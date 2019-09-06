package kae.study.codingchallenges.java.strings.token;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    final String s = new Scanner(System.in).nextLine().trim();
    if (s.isEmpty()) {
      System.out.println(0);
    } else {
      final String[] words = s.split("[ !,\\?\\.\\\\_'@]+");
      System.out.println(words.length);
      for (String word : words) {
        System.out.println(word);
      }
    }
  }
}
