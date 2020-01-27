package kae.study.codingchallenges.algorithms.arrays;

/**
 *
 */
class ImageRotator {

  void rotate(int[][] matrix) {
    if (matrix.length < 2) {
      return;
    }

    int length = matrix.length;
    int step = matrix.length - 1;

    for (int i = 0; i < length - 1; ++i) {
      for (int j = i; j < length - i - 1; ++j) {
        int row = i;
        int col = j;
        int current = matrix[row][col];
        for (int k = 0; k < 4; ++k) {
          int nextRow = Math.min(col, step);
          int nextCol = step - row;
          int next = matrix[nextRow][nextCol];
          matrix[nextRow][nextCol] = current;
          current = next;
          row = nextRow;
          col = nextCol;
        }
      }
    }
  }

}
