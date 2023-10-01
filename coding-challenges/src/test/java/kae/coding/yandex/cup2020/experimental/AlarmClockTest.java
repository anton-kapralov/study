package kae.coding.yandex.cup2020.experimental;

import static com.google.common.truth.Truth.assertThat;
import static kae.coding.yandex.cup2020.experimental.AlarmClock.solve;

import org.junit.Test;

/** */
public class AlarmClockTest {

  @Test
  public void test1() {
    assertThat(solve(6, 5, 10, new int[] {1, 2, 3, 4, 5, 6})).isEqualTo(10);
  }

  @Test
  public void test2() {
    assertThat(solve(5, 7, 12, new int[] {5, 22, 17, 13, 8})).isEqualTo(27);
  }
}
