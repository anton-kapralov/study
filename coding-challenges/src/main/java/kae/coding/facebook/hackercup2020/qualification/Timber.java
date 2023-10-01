package kae.coding.facebook.hackercup2020.qualification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Pine implements Comparable<Pine> {
  final int position;
  final int height;

  Pine(int position, int height) {
    this.position = position;
    this.height = height;
  }

  @Override
  public int compareTo(Pine another) {
    return Integer.compare(position, another.position);
  }
}

/** */
public class Timber {
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
    int pinesCount = scanner.nextInt();
    scanner.nextLine();

    List<Pine> pines = new ArrayList<>(pinesCount);
    for (int i = 0; i < pinesCount; i++) {
      int p = scanner.nextInt();
      int h = scanner.nextInt();
      pines.add(new Pine(p, h));
      scanner.nextLine();
    }

    long result = solve(pines);

    writer.printf("Case #%d: %d\n", caseNumber, result);
  }

  static long solve(List<Pine> pines) {
    pines.sort(Comparator.naturalOrder());

    long max = 0;
    Map<Integer, Long> map = new HashMap<>(pines.size() * 2);
    for (Pine pine : pines) {
      int l = pine.position - pine.height;
      int r = pine.position + pine.height;

      long lv = map.getOrDefault(l, 0L) + pine.height;
      long rv = map.getOrDefault(pine.position, 0L) + pine.height;

      map.merge(pine.position, lv, Math::max);
      map.merge(r, rv, Math::max);

      max = Math.max(max, Math.max(lv, rv));
    }

    return max;
  }
}
