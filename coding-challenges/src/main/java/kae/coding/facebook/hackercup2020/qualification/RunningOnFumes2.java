package kae.coding.facebook.hackercup2020.qualification;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

/** */
public class RunningOnFumes2 {

  static class Route {
    final int id;
    final long[] prices;
    final int tank;
    final int[] roots;
    final int from;
    final int to;
    long cost;

    Route(int id, long[] prices, int tank, int[] roots, int from, int to) {
      this.id = id;
      this.prices = prices;
      this.tank = tank;
      this.roots = roots;
      this.from = from;
      this.to = to;
    }
  }

  public static void main(String[] args) throws IOException {
    long start = System.currentTimeMillis();

    List<Route> routes = parseRoutes(args);

    List<Route> result =
        routes.stream()
            .parallel()
            .peek(
                route ->
                    route.cost = solve(route.tank, route.from, route.to, route.roots, route.prices))
            .collect(Collectors.toList());

    printResults(args, result);

    System.out.println(System.currentTimeMillis() - start + " ms");
  }

  private static void printResults(String[] args, List<Route> result) throws IOException {
    try (PrintWriter writer = getWriter(args)) {
      result.stream()
          .sorted(Comparator.comparingInt(route -> route.id))
          .forEach(route -> writer.printf("Case #%d: %d\n", route.id, route.cost));
    }
  }

  private static List<Route> parseRoutes(String[] args) throws IOException {
    List<Route> routes;
    try (Scanner scanner = getScanner(args)) {
      int t = scanner.nextInt();

      routes = new ArrayList<>(t);
      for (int i = 0; i < t; i++) {
        routes.add(parse(i + 1, scanner));
      }
    }
    return routes;
  }

  private static Scanner getScanner(String[] args) throws IOException {
    return args.length > 0 ? new Scanner(Paths.get(args[0])) : new Scanner(System.in);
  }

  private static PrintWriter getWriter(String[] args) throws FileNotFoundException {
    return args.length > 1
        ? new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]))))
        : new PrintWriter(System.out);
  }

  private static Route parse(int caseNumber, Scanner scanner) {
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    scanner.nextLine();

    int[] p = new int[n];
    long[] c = new long[n];
    for (int i = 0; i < n; ++i) {
      p[i] = scanner.nextInt();
      c[i] = scanner.nextLong();
      scanner.nextLine();
    }

    return new Route(caseNumber, c, m, p, a, b);
  }

  static class CityCost {
    final int city;
    final int cost;

    CityCost(int city, int cost) {
      this.city = city;
      this.cost = cost;
    }
  }

  static class FromToEttIndexes {
    final int from;
    final int to;
    int fromFirst = Integer.MAX_VALUE;
    int fromLast = Integer.MIN_VALUE;
    int toFirst = Integer.MAX_VALUE;
    int toLast = Integer.MIN_VALUE;

    public FromToEttIndexes(int from, int to) {
      this.from = from;
      this.to = to;
    }
  }

  static long solve(int tank, int from, int to, int[] roots, long[] prices) {
    int n = prices.length;
    if (tank >= n - 1) {
      return 0;
    }

    List<List<Integer>> graph = new ArrayList<>(n);
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 2; i <= n; i++) {
      int p = roots[i - 1];

      graph.get(p).add(i);
      graph.get(i).add(p);
    }

    int[] newRoots = new int[roots.length];
    newRoots[to - 1] = -1;
    rootAt(to, graph, newRoots);
    newRoots[to - 1] = 0;
    System.out.println(Arrays.toString(newRoots));

    int node = from;
    while (newRoots[node - 1] != 0) {
      System.out.println(node);
      node = newRoots[node - 1];
    }

    return 0;
  }

  private static void rootAt(int node, List<List<Integer>> tree, int[] roots) {
    for (Integer neighbor : tree.get(node)) {
      if (roots[neighbor - 1] == 0) {
        roots[neighbor - 1] = node;
        rootAt(neighbor, tree, roots);
      }
    }
  }

  private static int buildEulerTourTree(
      List<List<Integer>> tree,
      int root,
      int depth,
      int k,
      int[] ett,
      int[] depths,
      FromToEttIndexes ftei) {
    if (root == ftei.from) {
      ftei.fromFirst = ftei.fromLast = k;
    } else if (root == ftei.to) {
      ftei.toFirst = ftei.toLast = k;
    }
    ett[k] = root;
    depths[k] = depth;
    k++;
    for (int child : tree.get(root)) {
      k = buildEulerTourTree(tree, child, depth + 1, k, ett, depths, ftei);
      if (root == ftei.from) {
        ftei.fromLast = k;
      } else if (root == ftei.to) {
        ftei.toLast = k;
      }
      ett[k] = root;
      depths[k] = depth;
      k++;
    }

    return k;
  }

  private static void dfs(
      int[][] graph,
      boolean[] visited,
      int from,
      int tank,
      long[] costs,
      long[] prices,
      PriorityQueue<Long> heap,
      Deque<Integer> path) {
    for (int i = 0; i < graph.length; ++i) {
      if (graph[from][i] != 0 && !visited[i]) {
        visited[i] = true;

        System.out.println(i);

        if (prices[i] > 0) {
          heap.add(costs[i] + prices[i]);
        }
        path.addLast(i);

        dfs(graph, visited, i, tank, costs, prices, heap, path);

        path.removeLast();

        if (prices[i] > 0) {
          heap.remove(costs[i] + prices[i]);
        }
      }
    }
  }
}
