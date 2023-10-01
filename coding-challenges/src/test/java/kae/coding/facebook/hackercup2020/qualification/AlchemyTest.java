package kae.coding.facebook.hackercup2020.qualification;

import static com.google.common.truth.Truth.assertThat;
import static kae.coding.facebook.hackercup2020.qualification.Alchemy.solve;

import org.junit.Test;

public class AlchemyTest {

  @Test
  public void test_1() {
    assertThat(solve("BAB")).isTrue();
  }

  @Test
  public void test_2() {
    assertThat(solve("BBB")).isFalse();
  }

  @Test
  public void test_3() {
    assertThat(solve("AABBA")).isTrue();
  }

  @Test
  public void test_4() {
    assertThat(solve("BAAABAA")).isFalse();
  }

  @Test
  public void test_5() {
    assertThat(solve("BBBAABAAAAB")).isTrue();
  }

  @Test
  public void test_6() {
    assertThat(solve("BABBBABBABB")).isFalse();
  }
}
