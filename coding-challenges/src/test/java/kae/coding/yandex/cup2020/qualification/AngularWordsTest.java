package kae.coding.yandex.cup2020.qualification;

import static com.google.common.truth.Truth.assertThat;
import static kae.coding.yandex.cup2020.qualification.AngularWords.solve;

import org.junit.Test;

/** */
public class AngularWordsTest {

  @Test
  public void test1() {
    int result = solve(new char[][] {{'c', 'b', 'c'}, {'b', 'a', 'b'}}, "abc");
    assertThat(result).isEqualTo(4);
  }
}
