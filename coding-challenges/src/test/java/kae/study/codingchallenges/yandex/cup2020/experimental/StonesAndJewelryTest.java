package kae.study.codingchallenges.yandex.cup2020.experimental;

import static com.google.common.truth.Truth.assertThat;
import static kae.study.codingchallenges.yandex.cup2020.experimental.StonesAndJewelry.solve;

import org.junit.Test;

/**
 *
 */
public class StonesAndJewelryTest {

  @Test
  public void test1() {
    assertThat(solve("ab", "aabbccd")).isEqualTo(4);
  }
}
