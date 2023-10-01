package kae.coding.facebook.hackercup2020.qualification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/** */
public class Alchemy {

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

  private static void solve(int caseNumber, Scanner scanner, PrintWriter writer) {
    scanner.nextInt();
    scanner.nextLine();
    String s = scanner.nextLine();
    writer.printf("Case #%d: %s\n", caseNumber, solve(s) ? 'Y' : 'N');
  }

  static boolean solve(String s) {
    int a = 0;
    for (char c : s.toCharArray()) {
      if (c == 'A') {
        a++;
      }
    }

    int b = s.length() - a;

    return Math.abs(a - b) == 1;
  }
}
