package kae.coding.facebook.hackercup2020.qualification;

import static com.google.common.truth.Truth.assertThat;
import static kae.coding.facebook.hackercup2020.qualification.RunningOnFumes1.solve;

import org.junit.Test;

/** */
public class RunningOnFumes1Test {

  @Test
  public void test_1() {
    assertThat(solve(new long[] {0, 20, 30, 0, 10}, 3)).isEqualTo(20);
  }

  @Test
  public void test_2() {
    assertThat(solve(new long[] {0, 20, 30, 0, 10}, 2)).isEqualTo(30);
  }

  @Test
  public void test_3() {
    assertThat(solve(new long[] {0, 20, 30, 0, 10}, 1)).isEqualTo(-1);
  }

  @Test
  public void test_4() {
    assertThat(solve(new long[] {99, 88, 77, 66}, 1)).isEqualTo(165);
  }

  @Test
  public void test_5() {
    assertThat(solve(new long[] {99, 88, 77, 66}, 4)).isEqualTo(0);
  }

  @Test
  public void test_6() {
    assertThat(solve(new long[] {0, 0, 20, 30, 0, 10}, 2)).isEqualTo(50);
  }

  @Test
  public void test_7() {
    assertThat(solve(new long[] {0, 1, 4, 7, 0, 5, 9, 8, 0, 3, 0, 6}, 3)).isEqualTo(19);
  }
}
