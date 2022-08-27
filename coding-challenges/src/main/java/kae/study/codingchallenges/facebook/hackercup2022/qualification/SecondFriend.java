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
 * Boss Rob painted a beautiful scene on a 2D canvas of RR rows by CC columns, containing zero or
 * more happy little trees.
 * <p>
 * To make sure none of his trees are lonely, Rob would like you to add as many trees as you'd like
 * (possibly 00) to empty spaces so that each tree in the final painting has at least two tree
 * friends, that is, two trees which are each adjacent to it (directly to its north, south, east,
 * or west). If there are multiple solutions, you may print any one of them.
 */
public class SecondFriend {

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
    int m = scanner.nextInt();
    int n = scanner.nextInt();
    scanner.nextLine();
    int[][] canvas = new int[m][n];
    for (int i = 0; i < m; i++) {
      String s = scanner.nextLine();
      for (int j = 0; j < n; j++) {
        if (s.charAt(j) == '.') {
          continue;
        }
        canvas[i][j] = 1;
      }
    }
    boolean possible = solve(canvas);
    writer.printf("Case #%d: %s\n", caseNumber, possible ? "Possible" : "Impossible");
    if (!possible) {
      return;
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        writer.print(canvas[i][j] == 0 ? '.' : '^');
      }
      writer.println();
    }
  }

  private static boolean solve(int[][] canvas) {
    int m = canvas.length;
    int n = canvas[0].length;
    if (m < 2 || n < 2) {
      for (int[] row : canvas) {
        for (int j = 0; j < n; j++) {
          if (row[j] == 1) {
            return false;
          }
        }
      }
      return true;
    }
    for (int[] row : canvas) {
      Arrays.fill(row, 1);
    }
    return true;
  }
}
