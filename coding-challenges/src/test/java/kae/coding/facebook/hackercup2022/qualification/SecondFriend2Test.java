package kae.coding.facebook.hackercup2022.qualification;

import static com.google.common.truth.Truth.assertThat;
import static kae.coding.facebook.hackercup2022.qualification.SecondFriend2.solve;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class SecondFriend2Test {

  @Parameter public char[][] input;

  @Parameter(1)
  public boolean expected;

  @Parameters(name = "Test {index}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {new char[][] {{'.', '^', '.'}}, false},
          {new char[][] {{'.'}, {'#'}, {'#'}}, true},
          {new char[][] {{'^'}, {'#'}, {'#'}}, false},
          {
            new char[][] {
              {'.', '.'},
              {'.', '#'},
            },
            true
          },
          {
            new char[][] {
              {'^', '.'},
              {'.', '#'},
            },
            false
          },
          {
            new char[][] {
              {'.', '.'},
              {'.', '.'},
            },
            true
          },
          {
            new char[][] {
              {'#', '#'},
              {'#', '.'},
            },
            true
          },
          {
            new char[][] {
              {'#', '#'},
              {'#', '^'},
            },
            false
          },
          {
            new char[][] {
              {'#', '.', '#'},
              {'.', '^', '.'},
              {'#', '.', '#'},
            },
            false
          },
          {
            new char[][] {
              {'#', '.', '#'},
              {'.', '^', '.'},
              {'.', '.', '#'},
            },
            true
          },
          {
            new char[][] {
              {'.', '.', '^', '.'},
              {'.', '#', '^', '#'},
              {'.', '.', '.', '.'},
              {'.', '.', '.', '^'},
            },
            true
          },
        });
  }

  @Test
  public void solve_returnsExpected() {
    assertThat(solve(input)).isEqualTo(expected);
  }
}
