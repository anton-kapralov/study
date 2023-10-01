package kae.coding.yandex.cup2020.experimental;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
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
    Map<Integer, Integer> map = new HashMap<>();

    int min = Integer.MAX_VALUE;
    for (int t : ts) {
      map.merge(t % x, t, Integer::min);
      min = Math.min(min, t);
    }

    ts = new int[map.size()];
    int i = 0;
    for (Integer value : map.values()) {
      ts[i++] = value;
    }

    long l = 0;
    long r = min + (long) x * k;

    while (l <= r) {
      long m = (l + r) / 2;

      int count = count(m, x, ts);
      if (count == k) {
        return m;
      }

      if (count < k) {
        l = m + 1;
      } else {
        r = m - 1;
      }
    }

    return l;
  }

  private static int count(long ct, int x, int[] ts) {
    int c = 0;
    for (int t : ts) {
      if (ct < t) {
        continue;
      }
      c += (ct - t) / x + 1;
    }
    return c;
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
