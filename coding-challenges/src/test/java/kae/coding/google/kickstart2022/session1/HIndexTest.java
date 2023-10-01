package kae.coding.google.kickstart2022.session1;

import static com.google.common.truth.Truth.assertThat;
import static kae.coding.google.kickstart2022.session1.HIndex.getHIndexScore;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class HIndexTest {

  @Parameter public int[] input;

  @Parameter(value = 1)
  public int[] expected;

  @Parameters(name = "Test {index}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {new int[] {5, 1, 2}, new int[] {1, 1, 2}},
          {new int[] {1, 3, 3, 2, 2, 15}, new int[] {1, 1, 2, 2, 2, 3}},
          {new int[] {1, 3, 3, 2, 2, 15, 4, 3, 5, 6}, new int[] {1, 1, 2, 2, 2, 3, 3, 3, 3, 4}},
        });
  }

  @Test
  public void getHIndexScore_returnsExpected() {
    assertThat(getHIndexScore(input)).isEqualTo(expected);
  }
}
