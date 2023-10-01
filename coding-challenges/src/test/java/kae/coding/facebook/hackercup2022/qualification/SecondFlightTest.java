package kae.coding.facebook.hackercup2022.qualification;

import static com.google.common.truth.Truth.assertThat;
import static kae.coding.facebook.hackercup2022.qualification.SecondFlight.solve;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class SecondFlightTest {

  @Parameter public int[][] flights;

  @Parameter(1)
  public int[][] queries;

  @Parameter(2)
  public long[] expected;

  @Parameters(name = "Test {index}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {
            new int[][] {
              {0, 0, 0, 0, 0},
              {0, 0, 10, 5, 0},
              {0, 10, 0, 15, 10},
              {0, 5, 15, 0, 7},
              {0, 0, 10, 7, 0},
            },
            new int[][] {
              {1, 2},
              {1, 3},
              {2, 3},
              {2, 4},
              {3, 4},
              {4, 1},
            },
            new long[] {25, 20, 42, 27, 24, 15},
          },
          {
            new int[][] {
              {0, 0, 0, 0, 0},
              {0, 0, 10, 30, 0},
              {0, 10, 0, 20, 0},
              {0, 30, 20, 0, 0},
              {0, 0, 0, 0, 0},
            },
            new int[][] {
              {1, 2},
              {1, 3},
              {1, 4},
              {2, 3},
              {2, 4},
              {3, 4},
            },
            new long[] {40, 70, 0, 50, 0, 0},
          },
          {
            new int[][] {
              {0, 0, 0, 0, 0},
              {0, 0, 20, 0, 0},
              {0, 20, 0, 10, 0},
              {0, 0, 10, 0, 30},
              {0, 0, 0, 30, 0},
            },
            new int[][] {
              {1, 2},
              {1, 3},
              {1, 4},
              {2, 3},
              {2, 4},
              {3, 4},
            },
            new long[] {40, 10, 0, 20, 10, 60},
          }
        });
  }

  @Test
  public void solve_returnsExpected() {
    Map<Integer, Map<Integer, Integer>> flightsMap = new HashMap<>(flights.length);
    for (int i = 0; i < flights.length; i++) {
      int[] connections = flights[i];
      for (int j = 0; j < connections.length; j++) {
        int c = connections[j];
        if (c == 0) {
          continue;
        }
        flightsMap.computeIfAbsent(i, ignored -> new HashMap<>()).put(j, c);
      }
    }

    assertThat(solve(flightsMap, queries)).isEqualTo(expected);
  }
}
