package kae.coding.facebook.hackercup2023.practice;

import static com.google.common.truth.Truth.assertThat;
import static kae.coding.facebook.hackercup2023.practice.CheeseburgerCorollary2.solve;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

/** */
@RunWith(value = Parameterized.class)
public class CheeseburgerCorollary2Test {

  @Parameter public long a;

  @Parameter(1)
  public long b;

  @Parameter(2)
  public long c;

  @Parameter(3)
  public long k;

  @Parameterized.Parameters(name = "Test {index}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {2, 3, 5, 3}, // 1
          {2, 3, 2, 1}, // 2
          {2, 3, 1, 0}, // 3
          {5, 1, 100, 199}, // 4
          {1, 3, 100, 100}, // 5
          {1, 1, 1000000000000L, 1999999999999L}, // 6
        });
  }

  @Test
  public void solve_returnsExpected() {
    assertThat(solve(a, b, c)).isEqualTo(k);
  }
}
