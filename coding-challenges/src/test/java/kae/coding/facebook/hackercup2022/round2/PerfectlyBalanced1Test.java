package kae.coding.facebook.hackercup2022.round2;

import static com.google.common.truth.Truth.assertThat;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

/** */
@RunWith(value = Parameterized.class)
public class PerfectlyBalanced1Test {

  @Parameter public String s;

  @Parameter(1)
  public boolean expected;

  @SuppressWarnings("SpellCheckingInspection")
  @Parameterized.Parameters(name = "Test {index}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          { // 0
            "banan", true,
          },
          { // 1
            "anana", true,
          },
          { // 2
            "ban", false,
          },
          { // 3
            "nan", true,
          },
          { // 4
            "singing", true,
          },
          { // 5
            "prepare", true,
          },
          { // 6
            "baa", true,
          },
          { // 7
            "bbaaa", false,
          },
          { // 8
            "bba", true,
          },
          { // 9
            "bab", true,
          },
          { // 10
            "bbbbaaa", false,
          },
          { // 11
            "abb", true,
          },
          { // 12
            "a", true,
          },
          { // 13
            "xabxbb", false,
          },
          { // 14
            "aabbb", false,
          },
          { // 14
            "aaxb", false,
          },
        });
  }

  @Test
  public void solve() {
    assertThat(PerfectlyBalanced1.solve(s.toCharArray(), 0, s.length() - 1)).isEqualTo(expected);
  }
}
