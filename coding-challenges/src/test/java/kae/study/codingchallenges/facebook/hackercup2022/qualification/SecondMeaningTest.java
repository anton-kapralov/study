package kae.study.codingchallenges.facebook.hackercup2022.qualification;

import static com.google.common.truth.Truth.assertThat;
import static kae.study.codingchallenges.facebook.hackercup2022.qualification.SecondMeaning.solve;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class SecondMeaningTest {

  @Parameter
  public int n;

  @Parameter(1)
  public String first;

  @Parameter(2)
  public List<String> expected;

  @Parameters(name = "Test {index}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][]{
            {2, ".", List.of("-")},
            {2, "-", List.of(".")},
            {3, ".", List.of("-.", "--")},
            {3, ".-.", List.of("-.", "--")},
            {100, "-", List.of("...", "..-", ".-.")},
        });
  }

  @Test
  public void solve_returnsExpected() {
    assertThat(solve(n, first)).isEqualTo(expected);
  }
}