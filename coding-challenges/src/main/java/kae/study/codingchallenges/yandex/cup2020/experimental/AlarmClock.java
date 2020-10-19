package kae.study.codingchallenges.yandex.cup2020.experimental;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AlarmClock {

  public static void main(String[] args) throws IOException {
    try (Scanner scanner = getScanner(args);
        PrintWriter writer = getWriter(args)) {
      int n = scanner.nextInt();
      int x = scanner.nextInt();
      int k = scanner.nextInt();

      scanner.nextLine();

      int[] ts = new int[n];
      for (int i = 0; i < n; i++) {
        ts[i] = scanner.nextInt();
      }

      long r = solve(n, x, k, ts);

      writer.println(r);
    }
  }

  static long solve(int n, int x, int k, int[] ts) {
    PriorityQueue<Long> q = new PriorityQueue<>(n);
    for (int t : ts) {
      q.add((long) t);
    }

    long ct = -1;
    int c = 0;
    while (c < k) {
      long t = q.remove();
      if (t == ct) {
        continue;
      }
      c++;
      q.add(t + x);
      ct = t;
    }

    return ct;
  }

  private static Scanner getScanner(String[] args) throws IOException {
    return args.length > 0 ? new Scanner(Paths.get(args[0])) : new Scanner(System.in);
  }

  private static PrintWriter getWriter(String[] args) throws FileNotFoundException {
    return args.length > 1
        ? new PrintWriter(new OutputStreamWriter(new FileOutputStream(args[1])))
        : new PrintWriter(System.out);
  }
}
