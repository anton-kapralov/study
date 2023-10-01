package kae.coding.facebook.hackercup2022.round2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/** */
public class PerfectlyBalanced1 {
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
    char[] s = reader.readLine().toCharArray();
    int counter = 0;
    int q = Integer.parseInt(reader.readLine());
    for (int j = 0; j < q; j++) {
      String[] query = reader.readLine().split(" ");
      int l = Integer.parseInt(query[0]) - 1;
      int r = Integer.parseInt(query[1]) - 1;
      if (solve(s, l, r)) {
        counter++;
      }
    }
    writer.printf("Case #%d: %d\n", caseNumber, counter);
  }

  static boolean solve(char[] chars, int l, int r) {
    int[] map = new int['z' - 'a' + 1];
    int m = l + (r - l) / 2;
    for (int i = l; i < m; i++) {
      map[chars[i] - 'a']++;
    }
    for (int i = m; i <= r; i++) {
      map[chars[i] - 'a']--;
    }

    boolean evenLength = (r - l + 1) % 2 == 0;
    if (evenLength) {
      for (int v : map) {
        if (v != 0) {
          return false;
        }
      }
      return true;
    }

    int a = 0;
    int b = 0;

    for (int v : map) {
      if (v == 0) {
        continue;
      }
      if (a == 0) {
        a = v;
        continue;
      }
      if (b == 0) {
        b = v;
        continue;
      }
      return false;
    }

    switch (a) {
      case -2:
        return b == 1;
      case -1:
        return b == 2 || b == 0;
      case 1:
        return b == -2 || b == 0;
      case 2:
        return b == -1;
      default:
        return false;
    }
  }
}
