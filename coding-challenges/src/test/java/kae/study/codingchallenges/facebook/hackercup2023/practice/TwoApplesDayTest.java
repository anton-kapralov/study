package kae.study.codingchallenges.facebook.hackercup2023.practice;

import static com.google.common.truth.Truth.assertThat;
import static kae.study.codingchallenges.facebook.hackercup2023.practice.TwoApplesDay.solve;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

/** */
@RunWith(value = Parameterized.class)
public class TwoApplesDayTest {

  @Parameter public int[] ws;

  @Parameter(1)
  public int a;

  @Parameterized.Parameters(name = "Test {index}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {new int[] {6, 3, 1, 2, 5}, 4}, // 1
          {new int[] {7, 7, 7}, 7}, // 2
          {new int[] {1}, 1}, // 3
          {new int[] {1, 9, 1, 1, 4}, -1}, // 4
          {new int[] {1, 9, 1, 1, 4, 9, 9}, 6}, // 5
          {new int[] {1, 9, 10, 1, 4, 6, 9}, -1}, // 6
          {new int[] {1000000000, 2, 10, 4, 999999994}, 1000000002}, // 7
          {new int[] {100, 2, 10, 4, 94}, 102}, // 8
          {new int[] {6, 3, 4, 2, 5}, 1}, // 9
          {
            new int[] {
              4, 28, 36, 62, 22, 2, 30, 37, 20, 42, 42, 22, 38, 27, 22, 44, 62, 2, 34, 60, 26
            },
            42
          }, // 10
          {new int[] {9}, 1}, // 11
          {new int[] {13, 6, 6}, 13}, // 12
          {new int[] {4, 5, 2, 4, 3, 4, 3}, 3}, // 13
        });
  }

  @Test
  public void solve_returnsExpected() {
    assertThat(solve(ws)).isEqualTo(a);
  }
}
