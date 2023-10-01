package kae.coding.facebook.hackercup2020.qualification;

import static com.google.common.truth.Truth.assertThat;
import static kae.coding.facebook.hackercup2020.qualification.Timber.solve;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/** */
public class TimberTest {

  @Test
  public void test_1() {
    List<Pine> pines = new ArrayList<>(List.of(new Pine(0, 5), new Pine(5, 4)));

    assertThat(solve(pines)).isEqualTo(9);
  }

  @Test
  public void test_2() {
    List<Pine> pines = new ArrayList<>(List.of(new Pine(0, 5), new Pine(9, 4)));

    assertThat(solve(pines)).isEqualTo(9);
  }

  @Test
  public void test_3() {
    List<Pine> pines = new ArrayList<>(List.of(new Pine(0, 5), new Pine(9, 3), new Pine(2, 6)));

    assertThat(solve(pines)).isEqualTo(6);
  }

  @Test
  public void test_4() {
    List<Pine> pines =
        new ArrayList<>(
            List.of(
                new Pine(3, 2), new Pine(2, 8), new Pine(-4, 5), new Pine(8, 5), new Pine(1, 4)));

    assertThat(solve(pines)).isEqualTo(12);
  }

  @Test
  public void test_5() {
    List<Pine> pines =
        new ArrayList<>(
            List.of(
                new Pine(-15, 15),
                new Pine(-9, 9),
                new Pine(-3, 3),
                new Pine(5, 5),
                new Pine(9, 9),
                new Pine(18, 18)));

    assertThat(solve(pines)).isEqualTo(33);
  }

  @Test
  public void test_6() {
    List<Pine> pines =
        new ArrayList<>(
            List.of(
                new Pine(10, 20),
                new Pine(20, 20),
                new Pine(30, 20),
                new Pine(40, 20),
                new Pine(50, 20),
                new Pine(60, 20),
                new Pine(70, 20),
                new Pine(80, 20)));

    assertThat(solve(pines)).isEqualTo(80);
  }

  @Test
  public void test_7() {
    List<Pine> pines =
        new ArrayList<>(
            List.of(
                new Pine(13, 8),
                new Pine(-14, 5),
                new Pine(2, 19),
                new Pine(33, 10),
                new Pine(-31, 9),
                new Pine(15, 21),
                new Pine(5, 3),
                new Pine(-22, 16),
                new Pine(-6, 11),
                new Pine(25, 12),
                new Pine(-40, 24),
                new Pine(21, 18)));

    assertThat(solve(pines)).isEqualTo(56);
  }

  @Test
  public void test_8() {
    List<Pine> pines =
        new ArrayList<>(List.of(new Pine(-500000000, 500000000), new Pine(500000000, 500000000)));

    assertThat(solve(pines)).isEqualTo(1000000000);
  }
}
