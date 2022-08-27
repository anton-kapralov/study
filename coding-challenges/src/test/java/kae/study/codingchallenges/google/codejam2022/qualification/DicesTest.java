package kae.study.codingchallenges.google.codejam2022.qualification;

import static com.google.common.truth.Truth.assertThat;
import static kae.study.codingchallenges.google.codejam2022.qualification.Dices.solve;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class DicesTest {

  @Parameter public int[] input;

  @Parameter(value = 1)
  public int output;

  @Parameters(name = "Test {index}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {new int[] {6, 10, 12, 8}, 4},
          {new int[] {5, 4, 5, 4, 4, 4}, 5},
          {new int[] {10, 10, 7, 6, 7, 4, 4, 5, 7, 4}, 9},
          {new int[] {10}, 1},
        });
  }

  @Test
  public void test() {
    assertThat(solve(input)).isEqualTo(output);
  }
}
