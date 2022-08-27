package kae.study.codingchallenges.facebook.hackercup2022.qualification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Scanner;

class Index2D {

  final int r;
  final int c;

  public Index2D(int r, int c) {
    this.r = r;
    this.c = c;
  }
}

public class SecondFriend2 {

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
    char[][] canvas = new char[m][n];
    for (int i = 0; i < m; i++) {
      String s = scanner.nextLine();
      for (int j = 0; j < n; j++) {
        canvas[i][j] = s.charAt(j);
      }
    }
    boolean possible = solve(canvas);
    writer.printf("Case #%d: %s\n", caseNumber, possible ? "Possible" : "Impossible");
    if (!possible) {
      return;
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        writer.print(canvas[i][j]);
      }
      writer.println();
    }
  }

  private static final int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  static boolean solve(char[][] canvas) {
    int m = canvas.length;
    int n = canvas[0].length;

    ArrayDeque<Index2D> q = new ArrayDeque<>();
    int[][] map = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (canvas[i][j] == '#') {
          continue;
        }
        for (int[] dir : dirs) {
          int r = i + dir[0];
          int c = j + dir[1];
          if (r < 0 || r >= m || c < 0 || c >= n) {
            continue;
          }
          if (canvas[r][c] == '#') {
            continue;
          }
          map[i][j]++;
        }
        if (canvas[i][j] == '^' && map[i][j] < 2) {
          return false;
        }

        if (map[i][j] == 1) {
          q.add(new Index2D(i, j));
        }
      }
    }

    while (!q.isEmpty()) {
      int sz = q.size();
      for (int k = 0; k < sz; k++) {
        Index2D idx = q.removeFirst();
        if (canvas[idx.r][idx.c] == '^') {
          return false;
        }
        map[idx.r][idx.c] = 0;
        for (int[] dir : dirs) {
          int r = idx.r + dir[0];
          int c = idx.c + dir[1];
          if (r < 0 || r >= m || c < 0 || c >= n) {
            continue;
          }
          if (map[r][c] == 0) {
            continue;
          }
          if (canvas[r][c] == '^' && map[r][c] == 1) {
            return false;
          }
          map[r][c]--;
          if (map[r][c] == 1) {
            q.add(new Index2D(r, c));
          }
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] == 0) {
          continue;
        }
        canvas[i][j] = '^';
      }
    }

//    for (int[] ints : map) {
//      System.out.println(Arrays.toString(ints));
//    }
//    System.out.println();
    return true;
  }

}
