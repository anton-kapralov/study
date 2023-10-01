package kae.coding.algorithms.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/** */
public class Dijkstra {

  public static int[] findShortestDistances(List<List<int[]>> adjacentList, int from) {
    int n = adjacentList.size();
    if (n == 0) {
      return new int[0];
    }

    boolean[] processed = new boolean[n];
    int[] distances = new int[n];
    Arrays.fill(distances, Integer.MAX_VALUE);

    PriorityQueue<int[]> q =
        new PriorityQueue<>(Comparator.comparingInt(nodeDistance -> nodeDistance[1]));

    distances[from] = 0;
    q.add(new int[] {from, 0});

    while (!q.isEmpty()) {
      int[] nodeDistance = q.remove();
      int current = nodeDistance[0];

      if (processed[current]) {
        continue;
      }

      processed[current] = true;

      for (int[] adjacentNode : adjacentList.get(current)) {
        int adjacent = adjacentNode[0];
        int distance = adjacentNode[1];

        if (distances[adjacent] > distances[current] + distance) {
          distances[adjacent] = distances[current] + distance;
          q.add(new int[] {adjacent, distances[adjacent]});
        }
      }
    }

    return distances;
  }
}
