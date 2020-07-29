package kae.study.codingchallenges.facebook.hackercup2020.qualification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/** */
public class TravelRestrictions {

  public static void main(String[] args) throws IOException {
    try (Scanner scanner = new Scanner(Paths.get(args[0]));
        PrintWriter writer = getWriter(args)) {
      int t = scanner.nextInt();

      for (int i = 0; i < t; i++) {
        solve(i + 1, scanner, writer);
      }
    }
  }

  static void solve(int caseNumber, Scanner scanner, PrintWriter writer) {
    int n = scanner.nextInt();
    scanner.nextLine();
    boolean[] in = toBoolean(scanner.nextLine());
    boolean[] out = toBoolean(scanner.nextLine());
    boolean[][] result = solve(in, out);
    writer.printf("Case #%d: \n", caseNumber);
    for (boolean[] booleans : result) {
      for (boolean b : booleans) {
        writer.print(b ? 'Y' : 'N');
      }
      writer.println();
    }
  }

  private static boolean[][] solve(boolean[] in, boolean[] out) {
    int n = in.length;
    boolean[][] result = new boolean[n][n];

    for (int i = 0; i < n; ++i) {
      result[i][i] = true;
      for (int j = i + 1; j < n; j++) {
        result[i][j] = result[i][j - 1] && out[j - 1] && in[j];
      }
    }

    for (int i = n - 1; i >= 0; --i) {
      for (int j = i - 1; j >=0; --j) {
        result[i][j] = result[i][j + 1] && out[j + 1] && in[j];
      }
    }

    return result;
  }

  private static boolean[] toBoolean(String s) {
    char[] chars = s.toCharArray();
    boolean[] result = new boolean[chars.length];
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      result[i] = c == 'Y';
    }
    return result;
  }

  private static PrintWriter getWriter(String[] args) throws FileNotFoundException {
    return args.length > 1
        ? new PrintWriter(new OutputStreamWriter(new FileOutputStream(args[1])))
        : new PrintWriter(System.out);
  }
}
