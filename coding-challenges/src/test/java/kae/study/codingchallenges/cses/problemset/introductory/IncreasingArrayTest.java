package kae.study.codingchallenges.cses.problemset.introductory;

import static com.google.common.truth.Truth.assertThat;
import static kae.study.codingchallenges.cses.problemset.introductory.IncreasingArray.solve;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class IncreasingArrayTest {

  @Parameter public int[] input;

  @Parameter(value = 1)
  public long expected;

  @Parameters(name = "Test {index}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {new int[] {3, 2, 5, 1, 7}, 5},
          {new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 0},
          {new int[] {1000000000, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 8999999991L},
          {new int[] {6, 10, 4, 10, 2, 8, 9, 2, 7, 7}, 31},
        });
  }

  @Test
  public void solve_returnsExpected() {
    assertThat(solve(input)).isEqualTo(expected);
  }
}
