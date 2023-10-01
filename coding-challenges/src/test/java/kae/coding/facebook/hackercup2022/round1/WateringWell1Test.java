package kae.coding.facebook.hackercup2022.round1;

import static com.google.common.truth.Truth.assertThat;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

/** */
@RunWith(value = Parameterized.class)
public class WateringWell1Test {

  @Parameter public int[][] trees;

  @Parameter(1)
  public int[][] wells;

  @Parameter(2)
  public int expected;

  @Parameterized.Parameters(name = "Test {index}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          { // 0
            new int[][] {{2, 2}, {5, 5}}, new int[][] {{2, 5}, {6, 6}}, 52,
          },
          { // 1
            new int[][] {{1, 1}, {4, 3}, {6, 3}, {6, 5}}, new int[][] {{3, 1}, {5, 2}, {6, 5}}, 131,
          },
          { // 1
            new int[][] {
              {2837, 745},
              {62, 1162},
              {2634, 1112},
              {1746, 2618},
              {847, 127},
              {986, 1993},
              {732, 1273},
              {2003, 1998},
            },
            new int[][] {
              {1276, 2231},
              {1234, 1234},
              {287, 2371},
              {3000, 3000},
            },
            110090622,
          },
        });
  }

  @Test
  public void solve() {
    assertThat(WateringWell1.solve(trees, wells)).isEqualTo(expected);
  }
}
