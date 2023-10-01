package kae.coding.facebook.hackercup2022.round1;

import java.io.*;

/**
 * You have a deck of NN face-up cards, each displaying a unique integer between 11 and NN.
 *
 * <p>Cutting the deck once consists of taking a stack of between 11 and N - 1N−1 cards from the top
 * and moving it to the bottom in the same order. For example, for the deck [5,1,2,4,3] ordered from
 * top to bottom, cutting 22 cards from the top would yield [2,4,3,5,1].
 *
 * <p>Initially, the ith card from the top is Ai. Is it possible to cut the deck exactly K times to
 * reorder the deck such that the ith card from the top is Bi for all i?
 */
public class ConsecutiveCuts1 {

  public static void main(String[] args) throws IOException {
    long start = System.currentTimeMillis();
    try (BufferedReader scanner = new BufferedReader(new FileReader(args[0]));
        PrintWriter writer = getWriter(args)) {
      int t = Integer.parseInt(scanner.readLine());

      for (int i = 1; i <= t; i++) {
        long testCaseStart = System.currentTimeMillis();
        solve(i, scanner, writer);
        System.out.printf("Case #%02d: %d ms%n", i, System.currentTimeMillis() - testCaseStart);
      }
    }
    System.out.printf("%nTotal: %d ms%n", System.currentTimeMillis() - start);
  }

  private static PrintWriter getWriter(String[] args) throws FileNotFoundException {
    return new PrintWriter(
        new OutputStreamWriter(new FileOutputStream(args[0].replace("input", "output"))));
  }

  private static void solve(int caseNumber, BufferedReader reader, PrintWriter writer)
      throws IOException {
    String[] s = reader.readLine().split(" ");
    int n = Integer.parseInt(s[0]);
    int k = Integer.parseInt(s[1]);

    String as = reader.readLine();
    String bs = reader.readLine();

    boolean result = solve(n, k, as, bs);

    writer.printf("Case #%d: %s\n", caseNumber, result ? "YES" : "NO");
  }

  static boolean solve(int n, int k, String as, String bs) {
    if (k == 0) {
      return as.equals(bs);
    }

    return solve(k, as.split(" "), bs.split(" "));
  }

  static boolean solve(int k, String[] a, String[] b) {
    int n = a.length;

    int j = -1;
    for (int i = 0; i < n; i++) {
      if (b[i].equals(a[0])) {
        j = i;
        break;
      }
    }

    if (j == -1) {
      return false;
    }

    for (int i = 0; i < n; i++) {
      if (!a[i].equals(b[j])) {
        return false;
      }
      j++;
      j %= n;
    }

    if (k == 0) {
      return a[0].equals(b[0]);
    }

    if (n == 2) {
      return a[0].equals(b[0]) ? (k % 2 == 0) : (k % 2 == 1);
    }

    if (a[0].equals(b[0])) {
      return k != 1;
    }

    return true;
  }
}
