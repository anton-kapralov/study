package kae.study.codingchallenges.facebook.hackercup2022.qualification;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class SecondFlight {

  public static void main(String[] args) throws IOException {
    long start = System.currentTimeMillis();
    try (Scanner scanner = new Scanner(Paths.get(args[0]));
        PrintWriter writer = getWriter(args)) {
      int t = scanner.nextInt();

      for (int i = 0; i < t; i++) {
        solve(i + 1, scanner, writer);
      }
    }
    System.out.printf("%dms\n", System.currentTimeMillis() - start);
  }

  private static PrintWriter getWriter(String[] args) throws FileNotFoundException {
    return args.length > 1
        ? new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]))))
        : new PrintWriter(System.out);
  }

  static void solve(int caseNumber, Scanner scanner, PrintWriter writer) {
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int q = scanner.nextInt();

    Map<Integer, Map<Integer, Integer>> flights = new HashMap<>(n);
    for (int i = 0; i < m; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int c = scanner.nextInt();
      flights.computeIfAbsent(a, ignored -> new HashMap<>()).put(b, c);
      flights.computeIfAbsent(b, ignored -> new HashMap<>()).put(a, c);
    }
    int[][] queries = new int[q][2];
    for (int i = 0; i < q; i++) {
      queries[i][0] = scanner.nextInt();
      queries[i][1] = scanner.nextInt();
    }
    long[] result = solve(flights, queries);

    writer.printf("Case #%d:", caseNumber);
    for (long v : result) {
      writer.printf(" %d", v);
    }
    writer.println();
  }

  static long[] solve(Map<Integer, Map<Integer, Integer>> flights, int[][] queries) {
    long[] result = new long[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int x = queries[i][0];
      int y = queries[i][1];
      for (Entry<Integer, Integer> connection : flights.get(x).entrySet()) {
        int a = connection.getKey();
        int c = connection.getValue();
        if (a == y) {
          result[i] += c * 2L;
          continue;
        }
        Integer c2 = flights.get(a).get(y);
        if (c2 != null) {
          result[i] += Math.min(c, c2);
        }
      }
    }
    return result;
  }

}
