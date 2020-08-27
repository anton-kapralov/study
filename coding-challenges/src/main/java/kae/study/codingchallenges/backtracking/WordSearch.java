package kae.study.codingchallenges.backtracking;

/** */
public class WordSearch {

  //                                     Top      Right   Bottom  Left
  private static final int[][] MOVES = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  public boolean exist(char[][] board, String word) {
    int n = board.length;
    if (n == 0) {
      return false;
    }

    int m = board[0].length;

    boolean[][] visited = new boolean[n][m];
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < board[i].length; ++j) {
        if (board[i][j] != word.charAt(0)) {
          continue;
        }

        visited[i][j] = true;
        if (find(board, i, j, visited, word, 1)) {
          return true;
        }
        visited[i][j] = false;
      }
    }

    return false;
  }

  boolean find(char[][] board, int row, int col, boolean[][] visited, String word, int offset) {
    if (offset >= word.length()) {
      return true;
    }

    int n = board.length;
    int m = board[0].length;

    for (int[] move : MOVES) {
      int i = row + move[0];
      int j = col + move[1];

      if (i < 0 || i >= n || j < 0 || j >= m) {
        continue;
      }

      if (visited[i][j] || board[i][j] != word.charAt(offset)) {
        continue;
      }

      visited[i][j] = true;
      if (find(board, i, j, visited, word, offset + 1)) {
        return true;
      }
      visited[i][j] = false;
    }

    return false;
  }
}
