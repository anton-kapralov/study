package kae.study.codingchallenges.facebook.hackercup2020.qualification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Route {
  final int id;
  final long[] prices;
  final int tank;
  long cost;

  Route(int id, long[] prices, int tank) {
    this.id = id;
    this.prices = prices;
    this.tank = tank;
  }
}

/** */
public class RunningOnFumes1 {
  public static void main(String[] args) throws IOException {
    long start = System.currentTimeMillis();

    List<Route> routes = parseRoutes(args);

    List<Route> result =
        routes.stream()
            .parallel()
            .peek(route -> route.cost = solve(route.prices, route.tank))
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
    try (BufferedReader br = getBufferedReader(args)) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());

      routes = new ArrayList<>(t);
      for (int i = 0; i < t; i++) {
        Route route = parse(i + 1, br);
        routes.add(route);
      }
    }
    return routes;
  }

  private static BufferedReader getBufferedReader(String[] args) throws IOException {
    return args.length > 0
        ? new BufferedReader(new InputStreamReader(new FileInputStream(args[0])), 8192_0000)
        : new BufferedReader(new InputStreamReader(System.in));
  }

  private static Scanner getScanner(String[] args) throws IOException {
    return args.length > 0 ? new Scanner(Paths.get(args[0])) : new Scanner(System.in);
  }

  private static PrintWriter getWriter(String[] args) throws FileNotFoundException {
    return args.length > 1
        ? new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]))))
        : new PrintWriter(System.out);
  }

  private static Route parse(int caseNumber, BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n =  Integer.parseInt(st.nextToken());
    int m =  Integer.parseInt(st.nextToken());

    long[] c = new long[n];
    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      c[i] = Long.parseLong(st.nextToken());
    }

    return new Route(caseNumber, c, m);
  }

  static long solve(long[] prices, int tank) {
    int n = prices.length;
    if (tank >= n - 1) {
      return 0;
    }

    PriorityQueue<Long> heap = new PriorityQueue<>(tank);

    for (int i = 1; i <= tank; ++i) {
      if (prices[i] > 0) {
        heap.add(prices[i]);
      }
    }

    long[] costs = new long[n];

    for (int i = tank + 1; i < n; ++i) {
      if (heap.isEmpty()) {
        return -1;
      }
      long minPrice = heap.peek();
      costs[i] = minPrice;
      heap.remove(prices[i - tank] + costs[i - tank]);
      if (prices[i] > 0) {
        heap.add(costs[i] + prices[i]);
      }
    }

    return costs[n - 1];
  }
}
