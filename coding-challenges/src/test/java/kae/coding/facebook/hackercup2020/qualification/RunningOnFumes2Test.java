package kae.coding.facebook.hackercup2020.qualification;

import static com.google.common.truth.Truth.assertThat;
import static kae.coding.facebook.hackercup2020.qualification.RunningOnFumes2.solve;

import org.junit.Test;

/** */
public class RunningOnFumes2Test {

  @Test
  public void test_1() {
    int m = 1;
    int a = 2;
    int b = 3;
    int[] p = {0, 4, 4, 1};
    long[] c = {10, 20, 30, 40};

    assertThat(solve(m, a, b, p, c)).isEqualTo(40);
  }

  @Test
  public void test_2() {
    int m = 1;
    int a = 5;
    int b = 3;
    int[] p = {0, 3, 1, 7, 8, 1, 6, 6};
    long[] c = {30, 20, 0, 10, 0, 0, 20, 30};

    assertThat(solve(m, a, b, p, c)).isEqualTo(-1);
  }

  @Test
  public void test_3() {
    int m = 2;
    int a = 5;
    int b = 3;
    int[] p = {0, 3, 1, 7, 8, 1, 6, 6};
    long[] c = {30, 20, 0, 10, 0, 0, 20, 30};

    assertThat(solve(m, a, b, p, c)).isEqualTo(60);
  }

  @Test
  public void test_4() {
    int m = 3;
    int a = 5;
    int b = 3;
    int[] p = {0, 3, 1, 7, 8, 1, 6, 6};
    long[] c = {30, 20, 0, 10, 0, 0, 20, 30};

    assertThat(solve(m, a, b, p, c)).isEqualTo(20);
  }

  @Test
  public void test_5() {
    int m = 1;
    int a = 3;
    int b = 14;
    int[] p = {0, 1, 1, 2, 4, 4, 2, 5, 8, 9, 6, 2, 1, 8, 12};
    long[] c = {28, 18, 17, 8, 13, 2, 6, 37, 37, 21, 22, 33, 11, 5, 8};

    assertThat(solve(m, a, b, p, c)).isEqualTo(104);
  }

  @Test
  public void test_6() {
    int m = 5;
    int a = 11;
    int b = 12;
    int[] p = {0, 7, 1, 6, 15, 5, 15, 1, 8, 5, 2, 4, 6, 4, 1};
    long[] c = {0, 28, 19, 5, 0, 0, 0, 12, 6, 20, 0, 0, 10, 8, 22};

    assertThat(solve(m, a, b, p, c)).isEqualTo(17);
  }
}
