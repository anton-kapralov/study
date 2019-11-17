package kae.study.codingchallenges.games.conwaysgameoflife;

import static kae.study.codingchallenges.games.conwaysgameoflife.CellState.ALIVE;
import static kae.study.codingchallenges.games.conwaysgameoflife.CellState.DEAD;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Game of Life is a cellular automaton game devised by the British Mathematician John Horton
 * Conway. The original game is a zero player game. The evolution of it depends entirely on its
 * input.
 *
 * <p>Game of life takes place on a 2D grid. Each cell in the grid will be in one of the two
 * possible states,
 *
 * <ul>
 *   <li>ALIVE
 *   <li>DEAD
 * </ul>
 *
 * <p>The birth or death of the cells is based on the following rules.
 *
 * <ol>
 *   <li>A cell switches from DEAD to ALIVE if its surrounded exactly by 3 living cells.
 *   <li>A cell remains alive if its surrounded by 2 or 3 living cells.
 *   <li>A cell switches from being ALIVE to DEAD if its surrounded by more than 3 living cells
 *       because of over population.
 *   <li>A cell switches from being ALIVE to DEAD if its surrounded by less than 2 cells because of
 *       under population.
 * </ol>
 *
 * Each cell is surrounded by 8 cells, 4 on its sides and 4 on its corners. Cells at the extreme
 * corners have only 3 neighbors and the cells at the extreme right, left, top and bottom of the
 * board have 5 neighboring cells. The rules mentioned above applies for these cells as well.
 */
public final class Game {

  private static final CellState[][] initialGrid =
      new CellState[][] {
        {DEAD, DEAD, DEAD, DEAD, DEAD},
        {DEAD, DEAD, DEAD, ALIVE, DEAD},
        {DEAD, DEAD, ALIVE, DEAD, DEAD},
        {DEAD, ALIVE, DEAD, DEAD, DEAD},
        {DEAD, DEAD, DEAD, DEAD, DEAD}
      };

  public static void main(String[] args) {
    print(initialGrid);

    CellState[][] grid = initialGrid;
    for (int i = 0; i < 3; ++i) {
      grid = next(grid);
      print(grid);
    }
  }

  private static void print(CellState[][] grid) {
    for (CellState[] row : grid) {
      System.out.println(
          Arrays.stream(row).map(Objects::toString).collect(Collectors.joining(" ")));
    }
    System.out.println();
  }

  private static CellState[][] next(CellState[][] grid) {
    CellState[][] nextGrid = new CellState[grid.length][grid.length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        nextGrid[i][j] = nextState(grid, i, j);
      }
    }

    return nextGrid;
  }

  private static CellState nextState(CellState[][] grid, int row, int col) {
    int aliveCellsCount = countAliveNeighbors(grid, row, col);

    switch (grid[row][col]) {
      case DEAD:
        return aliveCellsCount == 3 ? ALIVE : DEAD;
      case ALIVE:
        if (aliveCellsCount == 2 || aliveCellsCount == 3) {
          return ALIVE;
        } else if (aliveCellsCount > 3) {
          return DEAD;
        } else {
          return DEAD;
        }
      default:
        throw new IllegalStateException("Unknown state " + grid[row][col]);
    }
  }

  private static int countAliveNeighbors(CellState[][] grid, int row, int col) {
    int count = 0;

    // Top Left
    if (row > 0 && col > 0) {
      if (grid[row - 1][col - 1] == ALIVE) {
        count++;
      }
    }

    // Top
    if (row > 0) {
      if (grid[row - 1][col] == ALIVE) {
        count++;
      }
    }

    // Top Right
    if (row > 0 && col < grid[row].length - 1) {
      if (grid[row - 1][col + 1] == ALIVE) {
        count++;
      }
    }

    // Left
    if (col > 0) {
      if (grid[row][col - 1] == ALIVE) {
        count++;
      }
    }

    // Right
    if (col < grid[row].length - 1) {
      if (grid[row][col + 1] == ALIVE) {
        count++;
      }
    }

    // Bottom Left
    if (row < grid.length - 1 && col > 0) {
      if (grid[row + 1][col - 1] == ALIVE) {
        count++;
      }
    }

    // Bottom
    if (row < grid.length - 1) {
      if (grid[row + 1][col] == ALIVE) {
        count++;
      }
    }

    // Bottom Right
    if (row < grid.length - 1 && col < grid[row].length - 1) {
      if (grid[row + 1][col + 1] == ALIVE) {
        count++;
      }
    }

    return count;
  }
}
