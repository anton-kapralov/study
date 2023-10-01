package kae.coding.algorithms.graphs;

import static com.google.common.truth.Truth.assertThat;
import static kae.coding.algorithms.graphs.Dijkstra.findShortestDistances;

import java.util.List;
import org.junit.Test;

/** */
public class DijkstraTest {

  @Test
  public void findShortestDistances_whenEmpty() {
    assertThat(findShortestDistances(List.of(), 0)).isEmpty();
  }

  @Test
  public void findShortestDistances_whenTwoNode() {
    int[] distances = findShortestDistances(List.of(List.of(new int[] {1, 10}), List.of()), 0);

    assertThat(distances[0]).isEqualTo(0);
    assertThat(distances[1]).isEqualTo(10);
  }

  @Test
  public void findShortestDistances_whenTwoPathsAndFirstIsLonger() {
    List<List<int[]>> adjacentList =
        List.of(
            List.of(new int[] {1, 10}, new int[] {3, 20}),
            List.of(new int[] {2, 30}),
            List.of(),
            List.of(new int[] {1, 10}, new int[] {2, 10}));

    int[] distances = findShortestDistances(adjacentList, 0);

    assertThat(distances[2]).isEqualTo(30);
  }
}
