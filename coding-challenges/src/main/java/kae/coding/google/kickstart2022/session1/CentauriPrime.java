package kae.coding.google.kickstart2022.session1;

import java.util.Scanner;

/**
 * Alice and Bob are playing the game called Centauri Prime. Centauri Prime represents a planet
 * which is split into several independent kingdoms. Before they start playing the game, they have
 * to choose rulers for each kingdom. Alice and Bob mutually decided to distribute kingdoms based on
 * the letter the kingdom's name ended with. Alice loves vowels and decided to rule kingdoms whose
 * names ended in a vowel. Bob loves consonants and decided to rule kingdoms whose names ended in a
 * consonant. Both of them do not like the letter 'y' and thus, all kingdoms whose names ended in
 * the letter 'y' are left without a ruler. Can you write a program that will determine the rulers
 * of several kingdoms, given the kingdoms' names?
 *
 * <p>https://codingcompetitions.withgoogle.com/kickstart/round/00000000008f4332/0000000000941ec5
 */
public class CentauriPrime {

  private static final boolean[] vmap = new boolean['z' - 'A' + 1];

  static {
    char[] vowels = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};

    for (char c : vowels) {
      vmap[c - 'A'] = true;
    }
  }

  public static String getRuler(String kingdom) {
    char lc = kingdom.charAt(kingdom.length() - 1);
    if (lc == 'Y' || lc == 'y') {
      return "nobody";
    }
    return vmap[lc - 'A'] ? "Alice" : "Bob";
  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int T = in.nextInt();

      for (int t = 1; t <= T; ++t) {
        String kingdom = in.next();
        System.out.println(
            "Case #" + t + ": " + kingdom + " is ruled by " + getRuler(kingdom) + ".");
      }
    }
  }
}
