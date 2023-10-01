package kae.coding.algorithms.strings.pangrams;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

  public static void main(String[] args) {
    Set<Character> dictionary =
        new TreeSet<>(
            new Comparator<Character>() {
              @Override
              public int compare(Character o1, Character o2) {
                return Character.toUpperCase(o1) - Character.toUpperCase(o2);
              }
            });

    for (char c = 'A'; c <= 'Z'; ++c) {
      dictionary.add(c);
    }
    for (char c = 'a'; c <= 'z'; ++c) {
      dictionary.add(c);
    }

    final String s = new Scanner(System.in).nextLine();
    final int length = s.length();
    for (int i = 0; i < length; ++i) {
      dictionary.remove(s.charAt(i));
    }

    System.out.println(dictionary.isEmpty() ? "pangram" : "not pangram");
  }
}
