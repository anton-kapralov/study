package kae.study.codingchallenges.liveramp.onlineasmt.task1;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

/**
 *
 */
public class SolutionTest {

  private final Solution s = new Solution();

  @Test
  public void test0() {
    assertThat(s.solution(null, 0)).isEqualTo("");
  }

  @Test
  public void test1() {
    assertThat(s.solution("Wed", 2)).isEqualTo("Fri");
  }

  @Test
  public void test2() {
    assertThat(s.solution("Sat", 23)).isEqualTo("Mon");
  }

  @Test
  public void test3() {
    assertThat(s.solution("Sat", 0)).isEqualTo("Sat");
  }

  @Test
  public void test4() {
    assertThat(s.solution("Sun", 1)).isEqualTo("Mon");
  }

  @Test
  public void test5() {
    assertThat(s.solution("Mon", 7)).isEqualTo("Mon");
  }

  @Test
  public void test6() {
    assertThat(s.solution("Tue", 8)).isEqualTo("Wed");
  }

  @Test
  public void test7() {
    assertThat(s.solution("Mon", 500)).isEqualTo("Thu");
  }
}
