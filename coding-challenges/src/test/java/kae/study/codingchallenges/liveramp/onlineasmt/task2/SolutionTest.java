package kae.study.codingchallenges.liveramp.onlineasmt.task2;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

/** */
public class SolutionTest {

  private final Solution s = new Solution();

  @Test
  public void test0() {
    assertThat(s.solution(new int[] {}, 0)).isEqualTo(-1);
  }

  @Test
  public void test1() {
    assertThat(s.solution(new int[] {4, 9, 8, 2, 6}, 3)).isEqualTo(18);
  }

  @Test
  public void test2() {
    assertThat(s.solution(new int[] {5, 6, 3, 4, 2}, 5)).isEqualTo(20);
  }

  @Test
  public void test3() {
    assertThat(s.solution(new int[] {7, 7, 7, 7, 7}, 1)).isEqualTo(-1);
  }

  @Test
  public void test4() {
    assertThat(s.solution(new int[] {1000}, 2)).isEqualTo(-1);
  }

  @Test
  public void test5() {
    assertThat(s.solution(new int[] {2, 3, 3, 5, 5}, 3)).isEqualTo(12);
  }

  @Test
  public void test6() {
    assertThat(s.solution(new int[] {1, 3, 3, 5, 5}, 3)).isEqualTo(-1);
  }

  @Test
  public void test7() {
    assertThat(s.solution(new int[] {1, 3, 3, 4, 5}, 3)).isEqualTo(12);
  }

  @Test
  public void test8() {
    assertThat(s.solution(new int[] {1, 1, 4, 4, 5}, 2)).isEqualTo(8);
  }

  @Test
  public void test9() {
    assertThat(s.solution(new int[] {1, 1, 4, 4, 9}, 2)).isEqualTo(10);
  }

  @Test
  public void test10() {
    assertThat(s.solution(new int[] {1, 3, 3, 5, 5}, 2)).isEqualTo(10);
  }

  @Test
  public void test11() {
    assertThat(s.solution(new int[] {6, 6, 7}, 3)).isEqualTo(-1);
  }

}
