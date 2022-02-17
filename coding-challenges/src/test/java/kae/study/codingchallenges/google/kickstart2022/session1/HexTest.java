package kae.study.codingchallenges.google.kickstart2022.session1;

import static com.google.common.truth.Truth.assertThat;
import static kae.study.codingchallenges.google.kickstart2022.session1.Hex.determineStatus;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class HexTest {

  @Parameter public char[][] input;

  @Parameter(value = 1)
  public String expected;

  @Parameters(name = "Test {index}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          // 0
          {new char[][] {{'.'}}, "Nobody wins"},
          // 1
          {new char[][] {{'B'}}, "Blue wins"},
          // 2
          {new char[][] {{'R'}}, "Red wins"},
          // 3
          {
            new char[][] {
              {'B', 'R'},
              {'B', 'B'}
            },
            "Impossible"
          },
          // 4
          {
            new char[][] {
              {'B', 'B', 'B', 'B'},
              {'B', 'B', 'B', '.'},
              {'R', 'R', 'R', '.'},
              {'R', 'R', 'R', 'R'},
            },
            "Blue wins"
          },
          // 5
          {
            new char[][] {
              {'B', 'B', 'B', 'B'},
              {'.', 'B', 'B', 'B'},
              {'.', 'R', 'R', 'R'},
              {'R', 'R', 'R', 'R'},
            },
            "Blue wins"
          },
          // 6
          {
            new char[][] {
              {'B', 'B', 'B', 'B'},
              {'B', 'B', 'B', 'B'},
              {'R', 'R', 'R', '.'},
              {'R', 'R', 'R', 'R'},
            },
            "Impossible"
          },
          // 7
          {
            new char[][] {
              {'B', 'B', 'B', 'B'},
              {'B', 'B', 'B', 'B'},
              {'.', 'R', 'R', 'R'},
              {'R', 'R', 'R', 'R'},
            },
            "Impossible"
          },
          // 8
          {
            new char[][] {
              {'.', '.', '.', '.', '.', '.'},
              {'.', '.', 'R', '.', '.', '.'},
              {'B', 'B', 'B', 'B', 'B', 'B'},
              {'.', '.', 'R', '.', 'R', '.'},
              {'.', '.', 'R', 'R', '.', '.'},
              {'.', '.', '.', '.', '.', '.'},
            },
            "Blue wins"
          },
          // 9
          {
            new char[][] {
              {'.', '.', 'R', '.', '.', '.'},
              {'.', '.', 'R', '.', '.', '.'},
              {'B', 'B', 'R', 'B', 'B', 'B'},
              {'.', '.', 'R', '.', 'B', '.'},
              {'.', '.', 'R', 'R', '.', '.'},
              {'.', '.', 'R', '.', '.', '.'},
            },
            "Red wins"
          },
          // 10
          {
            new char[][] {
              {'R', '.', '.', 'B'},
              {'R', 'R', 'B', 'B'},
              {'R', 'R', 'B', 'B'},
              {'R', 'R', 'B', 'B'},
            },
            "Red wins"
          },
          // 11
          {
            new char[][] {
              {'R', 'R', '.', 'B'},
              {'R', 'R', 'B', 'B'},
              {'R', 'R', 'B', 'B'},
              {'R', 'R', 'B', 'B'},
            },
            "Impossible"
          },
          // 12
          {
            new char[][] {
              {'R', 'B', '.', 'R'},
              {'R', 'B', 'B', 'R'},
              {'R', 'B', 'B', 'R'},
              {'R', 'B', 'B', 'R'},
            },
            "Impossible"
          },
          // 13
          {
            new char[][] {
              {'R', 'R', 'B'},
              {'R', 'B', 'B'},
              {'R', 'B', 'B'},
            },
            "Red wins"
          },
          // 14
          {
            new char[][] {
              {'B', 'R', 'R'},
              {'B', 'R', 'R'},
              {'B', 'B', 'B'},
            },
            "Blue wins"
          },
          // 15
          {
            new char[][] {
              {'R', 'R', 'B'},
              {'B', 'B', 'R'},
              {'B', 'R', 'B'},
            },
            "Blue wins"
          },
        });
  }

  @Test
  public void determineStatus_returnsExpected() {
    assertThat(determineStatus(input)).isEqualTo(expected);
  }
}
