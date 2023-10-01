package kae.coding.algorithms.arrays;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

/** */
public class ImageRotatorTest {

  private final ImageRotator imageRotator = new ImageRotator();

  @Test
  public void rotate_returnSame_whenSizeIs1x1() {
    int[][] matrix = {{1}};

    imageRotator.rotate(matrix);

    assertThat(matrix).isEqualTo(new int[][] {{1}});
  }

  @Test
  public void rotate_returnRotated_whenSizeIs2x2() {
    int[][] matrix = {{1, 2}, {3, 4}};

    imageRotator.rotate(matrix);

    assertThat(matrix).isEqualTo(new int[][] {{3, 1}, {4, 2}});
  }

  @Test
  public void rotate_returnRotated_whenSizeIs3x3() {
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    imageRotator.rotate(matrix);

    assertThat(matrix).isEqualTo(new int[][] {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}});
  }

  @Test
  public void rotate_returnRotated_whenSizeIs4x4() {
    int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

    imageRotator.rotate(matrix);

    assertThat(matrix)
        .isEqualTo(new int[][] {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}});
  }
}
