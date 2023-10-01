package kae.coding.facebook.hackercup2023.practice;

import static com.google.common.truth.Truth.assertThat;
import static kae.coding.facebook.hackercup2023.practice.DimSumDelivery.solve;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

/** */
@RunWith(value = Parameterized.class)
public class DimSumDeliveryTest {

  @Parameter public int r;

  @Parameter(1)
  public int c;

  @Parameter(2)
  public int a;

  @Parameter(3)
  public int b;

  @Parameter(4)
  public boolean result;

  @Parameterized.Parameters(name = "Test {index}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {2, 2, 1, 1, false}, // 1
          {5, 2, 3, 1, true}, // 2
          {4, 4, 3, 3, false}, // 3
        });
  }

  @Test
  public void solve_returnsExpected() {
    assertThat(solve(r, c, a, b)).isEqualTo(result);
  }
}
