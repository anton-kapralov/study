package kae.coding.matrices;

public class SpiralMatrix {

  public static char[][] getMatrix(int number) {
    switch (number) {
      case 0:
        return new char[][] {
          {'a', 'b', 'c', 'd'},
          {'e', 'f', 'g', 'h'},
          {'i', 'j', 'k', 'l'}
        };
      default:
        return new char[][] {};
    }
  }

  public static void main(String[] args) {
    char[][] matrix = getMatrix(0);

    int n = matrix.length;
    int m = n > 0 ? matrix[0].length : 0;

    int rowOffset = 0;
    int columnOffset = 0;

    while (columnOffset <= m / 2 || rowOffset <= n / 2) {
      // First row
      for (int j = columnOffset; j < m; ++j) {
        System.out.print(matrix[rowOffset][j]);
        System.out.print(' ');
      }

      // Last column
      for (int i = rowOffset + 1; i < n; ++i) {
        System.out.print(matrix[i][m - 1 - columnOffset]);
        System.out.print(' ');
      }

      // Bottom row
      for (int j = m - 2 - columnOffset; j >= columnOffset; --j) {
        System.out.print(matrix[n - 1 - rowOffset][j]);
        System.out.print(' ');
      }

      // First column
      for (int i = n - 2 - rowOffset; i >= rowOffset + 1; --i) {
        System.out.print(matrix[i][columnOffset]);
        System.out.print(' ');
      }

      rowOffset++;
      columnOffset++;

      n--;
      m--;
    }
  }
}
