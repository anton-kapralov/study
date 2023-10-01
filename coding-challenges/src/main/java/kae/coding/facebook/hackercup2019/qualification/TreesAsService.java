package kae.coding.facebook.hackercup2019.qualification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/** */
public class TreesAsService {

  public static void main(String[] args) throws IOException {
    try (Scanner scanner = new Scanner(Paths.get(args[0]));
        PrintWriter writer = getWriter(args)) {
      int cases = scanner.nextInt();
      for (int i = 1; i <= cases; ++i) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<int[]> rules = new ArrayList<>(m);
        for (int j = 0; j < m; ++j) {
          int[] rule = new int[3];
          rule[0] = scanner.nextInt();
          rule[1] = scanner.nextInt();
          rule[2] = scanner.nextInt();
          rules.add(rule);
        }

        int[] result = solve(n, rules);
        writer.printf("Case #%d: ", i);
        if (result == null) {
          writer.println("Impossible");
        } else {
          writer.println(
              Arrays.stream(result)
                  .skip(1)
                  .mapToObj(String::valueOf)
                  .collect(Collectors.joining(" ")));
        }
      }
    }
  }

  private static PrintWriter getWriter(String[] args) throws FileNotFoundException {
    return args.length > 1
        ? new PrintWriter(new OutputStreamWriter(new FileOutputStream(args[1])))
        : new PrintWriter(System.out);
  }

  private static int[] solve(int n, List<int[]> rules) {
    int[] link = new int[n + 1];

    for (int[] rule : rules) {
      int a = rule[0];
      int b = rule[1];
      int c = rule[2];

      if (!setPath(link, a, c) || !setPath(link, b, c)) {
        return null;
      }
    }

    for (int[] rule : rules) {
      int a = rule[0];
      int b = rule[1];
      int c = rule[2];

      if (!pathExists(link, a, c) || !setPath(link, b, c)) {
        return null;
      }
    }

    return link;
  }

  private static boolean setPath(int[] link, int from, int to) {
    if (pathExists(link, from, to)) {
      return true;
    }

    if (link[from] == 0) {
      link[from] = to;
      return !pathExists(link, to, from);
    } else {
      int current = link[from];
      link[from] = to;
      return setPath(link, to, current);
    }

    //    int a = from;
    //    int b = to;
    //
    //    while (link[from] != 0) {
    //      int current = link[from];
    //      link[from] = to;
    //      from = to;
    //      to = current;
    //    }
    //    link[from] = to;
    //
    //    return !pathExists(link, from, to) || !pathExists(link, to, from);
  }

  private static int top(int[] link, int node) {
    while (link[node] != 0) {
      node = link[node];
    }
    return node;
  }

  private static boolean pathExists(int[] link, int from, int to) {
    if (from == to) {
      return true;
    }

    while (link[from] != to && link[from] != 0) {
      from = link[from];
    }

    return link[from] == to;
  }
}
