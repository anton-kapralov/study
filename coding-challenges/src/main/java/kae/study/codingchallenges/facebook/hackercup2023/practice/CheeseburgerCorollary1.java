package kae.study.codingchallenges.facebook.hackercup2023.practice;

import java.io.*;

/** */
public class CheeseburgerCorollary1 {

  @SuppressWarnings("DuplicatedCode")
  public static void main(String[] args) throws IOException {
    long start = System.currentTimeMillis();
    try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        PrintWriter writer = getWriter(args)) {
      int t = Integer.parseInt(reader.readLine());

      for (int i = 1; i <= t; i++) {
        long testCaseStart = System.currentTimeMillis();
        solve(i, reader, writer);
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
    String[] ss = reader.readLine().split(" ");
    int s = Integer.parseInt(ss[0]);
    int d = Integer.parseInt(ss[1]);
    int k = Integer.parseInt(ss[2]);
    boolean result = solve(s, d, k);
    writer.printf("Case #%d: %s\n", caseNumber, result ? "YES" : "NO");
  }

  static boolean solve(int s, int d, int k) {
    int p = s + 2 * d;
    int c = s + 2 * d;
    int b = 2 * s + 2 * d;
    return k <= p && k <= c && (k + 1) <= b;
  }
}
