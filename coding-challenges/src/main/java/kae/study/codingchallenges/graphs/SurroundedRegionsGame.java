package kae.study.codingchallenges.graphs;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

/** */
enum Flag {
  X {
    @Override
    boolean is(char c) {
      return c == 'X';
    }

    @Override
    Flag opposite() {
      return O;
    }
  },
  O {
    @Override
    boolean is(char c) {
      return c == 'O';
    }

    @Override
    Flag opposite() {
      return X;
    }
  };

  abstract boolean is(char c);

  abstract Flag opposite();

  public static Flag valueOf(char c) {
    switch (c) {
      case 'X':
        return X;
      case 'O':
        return O;
      default:
        throw new IllegalArgumentException(String.valueOf(c));
    }
  }

  public char asChar() {
    return toString().charAt(0);
  }
}

class Point {
  final int row;

  final int col;

  final Flag flag;

  Point(int row, int col, Flag flag) {
    this.row = row;
    this.col = col;
    this.flag = flag;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Point point = (Point) o;

    return row == point.row && col == point.col;
  }

  @Override
  public int hashCode() {
    int result = row;
    result = 31 * result + col;
    return result;
  }
}

class Board {

  private static final int[][] adjacentDirections = {
    /* Top */ {-1, 0},
    /* Right */ {0, 1},
    /* Bottom */ {1, 0},
    /* Left */ {0, -1}
  };

  private final Point[][] points;
  private final int width;
  private final int height;

  Board(char[][] board) {
    width = board.length;
    height = board[0].length;
    this.points = new Point[width][height];

    for (int i = 0; i < width; ++i) {
      for (int j = 0; j < height; ++j) {
        this.points[i][j] = new Point(i, j, Flag.valueOf(board[i][j]));
      }
    }
  }

  Set<Point> getBorderPoints(Flag flag) {
    Set<Point> result = new HashSet<>();

    for (int j = 0; j < height; ++j) {
      addIfEqualToFlag(0, j, flag, result);
    }

    for (int i = 1; i < width; ++i) {
      addIfEqualToFlag(i, height - 1, flag, result);
    }

    for (int j = height - 2; j >= 0; --j) {
      addIfEqualToFlag(width - 1, j, flag, result);
    }

    for (int i = width - 2; i >= 1; --i) {
      addIfEqualToFlag(i, 0, flag, result);
    }

    return result;
  }

  private void addIfEqualToFlag(int row, int col, Flag flag, Collection<Point> points) {
    Point point = getPoint(row, col);
    if (point.flag.equals(flag)) {
      points.add(point);
    }
  }

  Point getPoint(int row, int col) {
    return points[row][col];
  }

  private Optional<Point> getAdjacent(Point point, int[] adjacentDirection) {
    int adjacentRow = point.row + adjacentDirection[0];
    int adjacentCol = point.col + adjacentDirection[1];
    if (adjacentRow >= 0 && adjacentRow < width && adjacentCol >= 0 && adjacentCol < height) {
      return Optional.of(getPoint(adjacentRow, adjacentCol));
    } else {
      return Optional.empty();
    }
  }

  Set<Point> getNonCaptured(Flag flag) {
    Set<Point> nonCaptured = getBorderPoints(flag);

    Queue<Point> queue = new ArrayDeque<>(nonCaptured);
    while (!queue.isEmpty()) {
      Point point = queue.poll();
      for (int[] adjacentDirection : adjacentDirections) {
        getAdjacent(point, adjacentDirection)
            .filter(adjacentPoint -> adjacentPoint.flag.equals(flag))
            .filter(nonCaptured::add)
            .ifPresent(queue::add);
      }
    }

    return nonCaptured;
  }

  public void flip(char[][] charBoard, Flag flag, Set<Point> nonCaptured) {
    for (int i = 1; i < width - 1; ++i) {
      for (int j = 1; j < height - 1; ++j) {
        Point point = getPoint(i, j);
        if (point.flag.equals(flag) && !nonCaptured.contains(point)) {
          charBoard[i][j] = point.flag.opposite().asChar();
        }
      }
    }
  }
}

public class SurroundedRegionsGame {

  public void solve(char[][] charBoard) {
    Board board = new Board(charBoard);

    board.flip(charBoard, Flag.O, board.getNonCaptured(Flag.O));
    board.flip(charBoard, Flag.X, board.getNonCaptured(Flag.X));
  }
}
