package kae.coding.facebook.hackercup2022.qualification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given one codeword C_1C 1 from a set of NN distinct codewords, your task is to generate another N
 * - 1N−1 codewords C_2, ..., C_NC 2 ,...,C N to yield an unambiguous encoding. It can be shown that
 * an answer always exists. If there are multiple answers, you may print any one of them.
 */
public class SecondMeaning {

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
    int n = scanner.nextInt();
    scanner.nextLine();
    String first = scanner.nextLine();
    List<String> dictionary = solve(n, first);
    writer.printf("Case #%d:\n", caseNumber);
    for (String s : dictionary) {
      writer.println(s);
    }
  }

  static List<String> solve(int n, String first) {
    ArrayDeque<String> q = new ArrayDeque<>();
    if (!first.startsWith(".")) {
      q.add(".");
    }
    if (!first.startsWith("-")) {
      q.add("-");
    }

    while (q.size() < n - 1) {
      int sz = q.size();
      for (int i = 0; i < sz; i++) {
        String s = q.removeFirst();
        String sdot = s + ".";
        if (!first.startsWith(sdot)) {
          q.add(sdot);
        }
        String sdash = s + "-";
        if (!first.startsWith(sdash)) {
          q.add(sdash);
        }
      }
    }

    List<String> result = new ArrayList<>(n);
    for (int i = 0; i < n - 1; i++) {
      result.add(q.removeFirst());
    }
    return result;
  }
}
