package kae.study.codingchallenges.facebook.hackercup2022.qualification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Sandy's store has NN pre-owned clock parts for sale, where the iith part is of style S_iS.
 * The store also has two display cases, each capable of holding at most KK parts. To maximize
 * the aesthetics of Sandy's secondhand second hands, she'd like to put each of the NN parts into
 * one of the two cases so that neither case ends up with two different parts of the same style,
 * and neither case has more than KK parts total. Can you determine if this is possible?
 */
public class SecondHand {

  public static void main(String[] args) throws IOException {
    try (Scanner scanner = new Scanner(Paths.get(args[0]));
        PrintWriter writer = getWriter(args)) {
      int t = scanner.nextInt();

      for (int i = 0; i < t; i++) {
        solve(i + 1, scanner, writer);
      }
    }
  }

  private static PrintWriter getWriter(String[] args) throws FileNotFoundException {
    return args.length > 1
        ? new PrintWriter(new OutputStreamWriter(new FileOutputStream(args[1])))
        : new PrintWriter(System.out);
  }

  static void solve(int caseNumber, Scanner scanner, PrintWriter writer) {
    int n = scanner.nextInt();
    int k = scanner.nextInt();
    int[] styles = new int[n];
    for (int i = 0; i < n; i++) {
      styles[i] = scanner.nextInt();
    }
    boolean result = solve(styles, k);
    writer.printf("Case #%d: %s\n", caseNumber, result ? "YES" : "NO");
  }

  static boolean solve(int[] styles, int limit) {
    if (styles.length > 2 * limit) {
      return false;
    }
    Arrays.sort(styles);
    int c = 1;
    for (int i = 1; i < styles.length; i++) {
      if (styles[i] == styles[i - 1]) {
        c++;
      } else {
        c = 1;
      }
      if (c > 2) {
        return false;
      }
    }
    return true;
  }

}
