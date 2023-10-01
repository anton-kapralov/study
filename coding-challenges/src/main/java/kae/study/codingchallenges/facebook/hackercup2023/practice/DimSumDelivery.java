package kae.study.codingchallenges.facebook.hackercup2023.practice;

import java.io.*;

/** */
@SuppressWarnings("DuplicatedCode")
public class DimSumDelivery {

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
    int r = Integer.parseInt(ss[0]);
    int c = Integer.parseInt(ss[1]);
    int a = Integer.parseInt(ss[2]);
    int b = Integer.parseInt(ss[3]);
    boolean result = solve(r, c, a, b);
    writer.printf("Case #%d: %s\n", caseNumber, result ? "YES" : "NO");
  }

  static boolean solve(int r, int c, int a, int b) {
    if (r <= 2) {
      return false;
    }
    if (c <= 2) {
      return true;
    }
    return r > c;
  }
}
