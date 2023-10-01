package kae.coding.cses.problemset.introductory;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/** https://cses.fi/problemset/task/1070 */
public class Permutations {
  public static void solve(int n) throws IOException {
    if (n == 1) {
      System.out.println(1);
      return;
    }
    if (n < 4) {
      System.out.println("NO SOLUTION");
      return;
    }

    try (OutputStream out = new BufferedOutputStream(System.out)) {
      out.write("2".getBytes());
      for (int i = 4; i <= n; i += 2) {
        out.write((" " + i).getBytes());
      }
      for (int i = 1; i <= n; i += 2) {
        out.write((" " + i).getBytes());
      }
    }
  }
}
