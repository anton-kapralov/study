package kae.study.codingchallenges.algorithms.basic;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.Test;

/** */
public class PermutationsTest {

  @Test
  public void test() {
    assertThat(new Permutations(3).asList())
        .containsExactlyElementsIn(
            List.of(
                List.of(0, 1, 2),
                List.of(0, 2, 1),
                List.of(1, 0, 2),
                List.of(1, 2, 0),
                List.of(2, 0, 1),
                List.of(2, 1, 0)));
  }
}
