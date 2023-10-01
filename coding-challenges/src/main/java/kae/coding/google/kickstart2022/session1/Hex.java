package kae.coding.google.kickstart2022.session1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * This problem was inspired by a board game called Hex, designed independently by Piet Hein and
 * John Nash. It has a similar idea, but does not assume you have played Hex.
 *
 * <p>This game is played on an N×N board, where each cell is a hexagon. There are two players: Red
 * side (using red stones) and Blue side (using blue stones). The board starts empty, and the two
 * players take turns placing a stone of their color on a single cell within the overall playing
 * board. Each player can place their stone on any cell not occupied by another stone of any color.
 * There is no requirement that a stone must be placed beside another stone of the same color. The
 * player to start first is determined randomly (with equal probability among the two players).
 *
 * <p>The upper side and lower sides of the board are marked as red, and the other two sides are
 * marked as blue. For each player, the goal of the game is to connect the two sides marked with
 * their color by forming a connected path using stones of their color. The first player to achieve
 * this wins. Note that the four corners are considered connected to both colors.
 *
 * <p>The game ends immediately when one player wins.
 *
 * <p>Given a game state, help someone new to the game determine the status of a game board. Say one
 * of the following:
 *
 * <p>Impossible: If it was impossible for two players to follow the rules and to have arrived at
 * that game state. Red wins: If the player playing the red stones has won. Blue wins: If the player
 * playing the blue stones has won. Nobody wins: If nobody has yet won the game. Note that a game of
 * Hex cannot end without a winner! Note that in any impossible state, the only correct answer is
 * Impossible, even if red or blue has formed a connected path of stones linking the opposing sides
 * of the board marked by their colors.
 */
public class Hex {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Read the number of test cases.
    int t = scanner.nextInt();
    for (int caseIndex = 1; caseIndex <= t; caseIndex++) {
      // Read the board size.
      int n = scanner.nextInt();
      // Read each row of the board.
      char[][] board = new char[n][];
      for (int i = 0; i < n; i++) {
        board[i] = scanner.next().toCharArray();
      }
      // Determine the game status and display it.
      String status = determineStatus(board);
      System.out.println("Case #" + caseIndex + ": " + status);
    }
  }

  private static final int[][] directions = {{0, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, 0}, {-1, 1}};

  /** Returns a status string as specified by the Hex problem statement. */
  static String determineStatus(char[][] board) {
    int bc = count('B', board);
    int rc = count('R', board);
    if (Math.abs(bc - rc) > 1) {
      return "Impossible";
    }

    boolean blueWins = false;
    boolean redWins = false;

    int n = board.length;
    for (int i = 0; i < n; i++) {
      if (!blueWins && board[i][0] == 'B') {
        blueWins = bfs('B', board, i, 0, new boolean[n][n]);
      }
      if (!redWins && board[0][i] == 'R') {
        redWins = bfs('R', board, 0, i, new boolean[n][n]);
      }
    }

    if (blueWins && redWins) {
      return "Impossible";
    }

    if (blueWins) {
      if (bc != rc && bc - rc != 1) {
        return "Impossible";
      }

      return "Blue wins";
    }

    if (redWins) {
      if (bc != rc && rc - bc != 1) {
        return "Impossible";
      }
      return "Red wins";
    }

    return "Nobody wins";
  }

  private static int count(char player, char[][] board) {
    int c = 0;
    int n = board.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] != player) {
          continue;
        }
        c++;
      }
    }
    return c;
  }

  private static boolean bfs(
      char player, char[][] board, int fromRow, int fromCol, boolean[][] visited) {
    int n = board.length;
    Deque<Integer> dq = new ArrayDeque<>(n);
    visited[fromRow][fromCol] = true;
    dq.add(flatten(fromRow, fromCol, n));
    while (!dq.isEmpty()) {
      int sz = dq.size();
      for (int l = 0; l < sz; l++) {
        int idx = dq.remove();
        int r = idx / n;
        int c = idx % n;

        if (player == 'B' && c == n - 1) {
          return true;
        }

        if (player == 'R' && r == n - 1) {
          return true;
        }

        for (int[] dir : directions) {
          int nr = r + dir[0];
          int nc = c + dir[1];
          if (nr < 0 || nr == n || nc < 0 || nc == n) {
            continue;
          }
          if (board[nr][nc] != player || visited[nr][nc]) {
            continue;
          }
          visited[nr][nc] = true;
          dq.add(flatten(nr, nc, n));
        }
      }
    }

    return false;
  }

  private static int flatten(int r, int c, int n) {
    return r * n + c;
  }
}
