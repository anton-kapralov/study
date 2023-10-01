package kae.coding.google.kickstart2022.session1;

import static com.google.common.truth.Truth.assertThat;
import static kae.coding.google.kickstart2022.session1.CentauriPrime.getRuler;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class CentauriPrimeTest {

  @Parameter public String input;

  @Parameter(value = 1)
  public String expected;

  @Parameters(name = "Test {index}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {"Mollaristan", "Bob"},
          {"Auritania", "Alice"},
          {"Zizily", "nobody"},
        });
  }

  @Test
  public void getRuler_returnsExpected() {
    assertThat(getRuler(input)).isEqualTo(expected);
  }
}
