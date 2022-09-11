package kae.study.codingchallenges.facebook.hackercup2022.round1;

import java.io.*;

public class WateringWell1 {

  private static final int M = 1_000_000_007;
  private static final int BOUND = 3001;

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
    return new PrintWriter(new OutputStreamWriter(new FileOutputStream(args[0].replace("input", "output"))));
  }

  private static void solve(int caseNumber, BufferedReader reader, PrintWriter writer) throws IOException {
    int[][] trees = parseCoordinates(reader);
    int[][] wells = parseCoordinates(reader);
    int result = solve(trees, wells);
    writer.printf("Case #%d: %d\n", caseNumber, result);
  }

  private static int[][] parseCoordinates(BufferedReader reader) throws IOException {
    int n = Integer.parseInt(reader.readLine());
    int[][] coordinates = new int[n][2];
    for (int i = 0; i < n; i++) {
      String[] ln = reader.readLine().split(" ");
      coordinates[i][0] = Integer.parseInt(ln[0]);
      coordinates[i][1] = Integer.parseInt(ln[1]);
    }
    return coordinates;
  }

  static int solve(int[][] trees, int[][] wells) {
    int[] txs = new int[BOUND];
    int[] tys = new int[BOUND];
    for (int[] tree : trees) {
      txs[tree[0]]++;
      tys[tree[1]]++;
    }

    int[] wxs = new int[BOUND];
    int[] wys = new int[BOUND];
    for (int[] well : wells) {
      wxs[well[0]]++;
      wys[well[1]]++;
    }

    int s = sum(txs, wxs);
    s += sum(tys, wys);
    s %= M;

    return s;
  }

  private static int sum(int[] ts, int[] ws) {
    long s = 0;

    for (int wx = 0; wx < BOUND; wx++) {
      long wc = ws[wx];
      if (wc == 0) {
        continue;
      }

      for (int tx = 0; tx < BOUND; tx++) {
        long tc = ts[tx];
        if (tc == 0) {
          continue;
        }

        long v = (wx - tx) * (wx - tx);
        long m = wc * tc;
        v *= m;

        s += v;
        s %= M;
      }
    }
    return (int) s;
  }

}
