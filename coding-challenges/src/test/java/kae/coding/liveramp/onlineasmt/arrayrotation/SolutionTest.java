package kae.coding.liveramp.onlineasmt.arrayrotation;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

/** */
public class SolutionTest {

  private final Solution s = new Solution();

  @Test
  public void test1() {
    assertThat(s.solution(new int[] {3, 8, 9, 7, 6}, 3)).isEqualTo(new int[] {9, 7, 6, 3, 8});
  }

  @Test
  public void test2() {
    assertThat(s.solution(new int[] {3, 8, 9, 7, 6}, 8)).isEqualTo(new int[] {9, 7, 6, 3, 8});
  }

  @Test
  public void test3() {
    assertThat(s.solution(new int[] {3, 8, 9, 7, 6}, 5)).isEqualTo(new int[] {3, 8, 9, 7, 6});
  }

  @Test
  public void test4() {
    assertThat(s.solution(new int[] {3, 8, 9, 7, 6}, 1)).isEqualTo(new int[] {6, 3, 8, 9, 7});
  }
}
