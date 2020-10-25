package kae.study.codingchallenges.yandex.cup2020.qualification;

import static com.google.common.truth.Truth.assertThat;
import static kae.study.codingchallenges.yandex.cup2020.qualification.SimilarRows.potentiallyEqual;

import org.junit.Test;

/** */
public class SimilarRowsTest {

  @Test
  public void test1_potentiallyEqual() {
    assertThat(
            potentiallyEqual(
                new boolean[] {false, true, true},
                new String[] {"a", "b", ""},
                new String[] {"", "b", "c"}))
        .isTrue();
  }

  @Test
  public void test2_potentiallyEqual() {
    assertThat(
            potentiallyEqual(
                new boolean[] {false, true, true},
                new String[] {"a", "b", ""},
                new String[] {"", "", "c"}))
        .isFalse();
  }

  @Test
  public void test3_potentiallyEqual() {
    assertThat(
            potentiallyEqual(
                new boolean[] {false, true, true},
                new String[] {"a", "", ""},
                new String[] {"", "", ""}))
        .isFalse();
  }

  @Test
  public void test4_potentiallyEqual() {
    assertThat(
            potentiallyEqual(
                new boolean[] {false, true, true},
                new String[] {"a", "", "c"},
                new String[] {"", "", "c"}))
        .isTrue();
  }
}
