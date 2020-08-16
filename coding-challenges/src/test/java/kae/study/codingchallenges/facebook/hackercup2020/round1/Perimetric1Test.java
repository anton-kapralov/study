package kae.study.codingchallenges.facebook.hackercup2020.round1;

import static com.google.common.truth.Truth.assertThat;
import static kae.study.codingchallenges.facebook.hackercup2020.round1.Perimetric1.solve;

import org.junit.Test;

/** */
public class Perimetric1Test {

  @Test
  public void test1() {
    FloorPlan floorPlan =
        FloorPlan.newBuilder()
            .setRoomsCount(2)
            .setK(2)
            .setWidth(2)
            .setLefts(new long[] {1, 2})
            .setHeights(new long[] {3, 3})
            .build();

    assertThat(solve(floorPlan)).isEqualTo(120);
  }

  @Test
  public void test2() {
    FloorPlan floorPlan =
        FloorPlan.newBuilder()
            .setRoomsCount(2)
            .setK(2)
            .setWidth(2)
            .setLefts(new long[] {10, 20})
            .setHeights(new long[] {3, 3})
            .build();

    assertThat(solve(floorPlan)).isEqualTo(200);
  }

  /*
   5 5 3
   2 4 5 9 12
   0 0 0 100
   4 3 6 3 2
   0 0 0 100

   P=[14,18,24,36,42].
  */
  @Test
  public void test3() {
    FloorPlan floorPlan =
        FloorPlan.newBuilder()
            .setRoomsCount(5)
            .setK(5)
            .setWidth(3)
            .setLefts(new long[] {2, 4, 5, 9, 12})
            .setHeights(new long[] {4, 3, 6, 3, 2})
            .build();

    assertThat(solve(floorPlan)).isEqualTo(9144576);
  }

  /*
   10 3 8
   9 14 15
   0 1 3 53
   12 7 16
   5 2 1 38

   L = [9, 14, 15, 19, 23,27,31,35,39,43]
   H = [12, 7, 16, 31, 30, 27, 16, 17, 2, 15]H=[12,7,16,31,30,27,16,17,2,15]
   P = [40, 50, 60, 98, 106, 114, 122, 130, 138, 146]P=[40,50,60,98,106,114,122,130,138,146]
  */
  @Test
  public void test4() {
    FloorPlan floorPlan =
        FloorPlan.newBuilder()
            .setRoomsCount(10)
            .setK(3)
            .setWidth(8)
            .setLefts(new long[] {9, 14, 15})
            .setLeftConstants(0, 1, 3, 53)
            .setHeights(new long[] {12, 7, 16})
            .setHeightConstants(5, 2, 1, 38)
            .build();

    assertThat(solve(floorPlan)).isEqualTo(803986060);
  }

  /*
   50 10 17
   4 9 10 26 28 59 97 100 105 106
   1 0 7 832
   130 12 82 487 12 30 214 104 104 527
   21 81 410 605
  */
  @Test
  public void test5() {
    FloorPlan floorPlan =
        FloorPlan.newBuilder()
            .setRoomsCount(50)
            .setK(10)
            .setWidth(17)
            .setLefts(new long[] {4, 9, 10, 26, 28, 59, 97, 100, 105, 106})
            .setLeftConstants(1, 0, 7, 832)
            .setHeights(new long[] {130, 12, 82, 487, 12, 30, 214, 104, 104, 527})
            .setHeightConstants(21, 81, 410, 605)
            .build();

    assertThat(solve(floorPlan)).isEqualTo(271473330);
  }

  @Test
  public void test6() {
    FloorPlan floorPlan =
        FloorPlan.newBuilder()
            .setRoomsCount(2)
            .setK(2)
            .setWidth(4)
            .setLefts(new long[] {0, 5})
            .setHeights(new long[] {1, 2})
            .build();

    assertThat(solve(floorPlan)).isEqualTo(220);
  }

  @Test
  public void test7() {
    FloorPlan floorPlan =
        FloorPlan.newBuilder()
            .setRoomsCount(3)
            .setK(3)
            .setWidth(4)
            .setLefts(new long[] {0, 5, 8})
            .setHeights(new long[] {1, 2, 1})
            .build();

    assertThat(solve(floorPlan)).isEqualTo(6160);
  }

  @Test
  public void test8() {
    FloorPlan floorPlan =
        FloorPlan.newBuilder()
            .setRoomsCount(4)
            .setK(4)
            .setWidth(4)
            .setLefts(new long[] {0, 5, 8, 13})
            .setHeights(new long[] {1, 2, 1, 1})
            .build();

    assertThat(solve(floorPlan)).isEqualTo(234080);
  }

  @Test
  public void test9() {
    FloorPlan floorPlan =
        FloorPlan.newBuilder()
            .setRoomsCount(5)
            .setK(5)
            .setWidth(4)
            .setLefts(new long[] {0, 5, 8, 13, 15})
            .setHeights(new long[] {1, 2, 1, 1, 2})
            .build();

    assertThat(solve(floorPlan)).isEqualTo(10299520);
  }

  @Test
  public void test10() {
    FloorPlan floorPlan =
        FloorPlan.newBuilder()
            .setRoomsCount(6)
            .setK(6)
            .setWidth(4)
            .setLefts(new long[] {0, 5, 8, 13, 15, 20})
            .setHeights(new long[] {1, 2, 1, 1, 2, 1})
            .build();

    assertThat(solve(floorPlan)).isEqualTo(556174080);
  }

  @Test
  public void test11() {
    FloorPlan floorPlan =
        FloorPlan.newBuilder()
            .setRoomsCount(7)
            .setK(7)
            .setWidth(4)
            .setLefts(new long[] {0, 5, 8, 13, 15, 20, 25})
            .setHeights(new long[] {1, 2, 1, 1, 2, 1, 1})
            .build();

    assertThat(solve(floorPlan)).isEqualTo(595140875);
  }

  @Test
  public void test12() {
    FloorPlan floorPlan =
        FloorPlan.newBuilder()
            .setRoomsCount(8)
            .setK(8)
            .setWidth(4)
            .setLefts(new long[] {0, 5, 8, 13, 15, 20, 25, 29})
            .setHeights(new long[] {1, 2, 1, 1, 2, 1, 1, 1})
            .build();

    assertThat(solve(floorPlan)).isEqualTo(850142706);
  }

  @Test
  public void test13() {
    FloorPlan floorPlan =
        FloorPlan.newBuilder()
            .setRoomsCount(4)
            .setK(4)
            .setWidth(4)
            .setLefts(new long[] {2, 3, 4, 7})
            .setHeights(new long[] {9, 1, 5, 12})
            .build();

    assertThat(solve(floorPlan)).isEqualTo(1092000);
  }

  @Test
  public void test14() {
    FloorPlan floorPlan =
        FloorPlan.newBuilder()
            .setRoomsCount(3)
            .setK(3)
            .setWidth(3)
            .setLefts(new long[] {1, 3, 4})
            .setHeights(new long[] {6, 3, 4})
            .build();

    assertThat(solve(floorPlan)).isEqualTo(9504);
  }

  @Test
  public void test15() {
    FloorPlan floorPlan =
        FloorPlan.newBuilder()
            .setRoomsCount(3)
            .setK(3)
            .setWidth(3)
            .setLefts(new long[] {1, 4, 7})
            .setHeights(new long[] {6, 3, 4})
            .build();

    assertThat(solve(floorPlan)).isEqualTo(13824);
  }
}
