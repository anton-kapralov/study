package kae.study.codingchallenges.facebook.hackercup2023.practice;

import static java.lang.Math.min;

import java.io.*;

/** */
public class CheeseburgerCorollary2 {

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
    long a = Long.parseLong(ss[0]);
    long b = Long.parseLong(ss[1]);
    long c = Long.parseLong(ss[2]);
    long k = solve(a, b, c);
    writer.printf("Case #%d: %d\n", caseNumber, k);
  }

  static long solve(long a, long b, long c) {
    long s = 0;
    long d = 0;
    if (2 * a <= b) {
      s = c / a;
      d = (c % a) / b;
    } else {
      d = c / b;
      s = (c % b) / a;
    }
    return Math.max(0, min(s + 2 * d, 2 * s + 2 * d - 1));
  }
}
