package kae.coding.yandex.cup2020.experimental;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/** */
public class StonesAndJewelry {

  public static void main(String[] args) throws IOException {
    try (Scanner scanner = getScanner(args);
        PrintWriter writer = getWriter(args)) {
      String j = scanner.nextLine();
      String s = scanner.nextLine();
      int r = solve(j, s);
      writer.println(r);
    }
  }

  private static Scanner getScanner(String[] args) throws IOException {
    return args.length > 0 ? new Scanner(Paths.get(args[0])) : new Scanner(System.in);
  }

  private static PrintWriter getWriter(String[] args) throws FileNotFoundException {
    return args.length > 1
        ? new PrintWriter(new OutputStreamWriter(new FileOutputStream(args[1])))
        : new PrintWriter(System.out);
  }

  static int solve(String j, String s) {
    boolean[] map = new boolean[128];
    for (char c : j.toCharArray()) {
      map[c] = true;
    }

    int n = 0;
    for (char c : s.toCharArray()) {
      if (map[c]) {
        n++;
      }
    }

    return n;
  }
}
