package kae.coding.facebook.hackercup2022.qualification;

import static com.google.common.truth.Truth.assertThat;
import static kae.coding.facebook.hackercup2022.qualification.SecondHand.solve;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class SecondHandTest {

  @Parameter public int[] styles;

  @Parameter(1)
  public int limit;

  @Parameter(2)
  public boolean expected;

  /*
    5
  3 2
  1 2 2
  5 3
  1 2 3 3 1
  5 2
  1 2 3 4 5
  5 5
  1 1 2 2 1
  1 1
  1
    * */
  @Parameters(name = "Test {index}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {new int[] {1, 2, 2}, 2, true},
          {new int[] {1, 2, 3, 3, 1}, 3, true},
          {new int[] {1, 2, 3, 4, 5}, 2, false},
          {new int[] {1, 1, 2, 2, 1}, 5, false},
          {new int[] {1}, 1, true},
        });
  }

  @Test
  public void solve_returnsExpected() {
    assertThat(solve(styles, limit)).isEqualTo(expected);
  }
}
