package kae.study.codingchallenges.yandex.cup2020.qualification;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Trie {

  static class Node {
    private final Map<Character, Node> children = new HashMap<>();
    private boolean terminal;
  }

  private final Node root = new Node();

  public void add(CharSequence s) {
    if (s.length() == 0) {
      return;
    }

    Node node = root;
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      node = node.children.computeIfAbsent(c, ignored -> new Node());
    }
    node.terminal = true;
  }

  private Node lastNodeOf(CharSequence s) {
    Node node = root;
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      node = node.children.get(c);
      if (node == null) {
        return null;
      }
    }

    return node;
  }

  public boolean hasWord(CharSequence s) {
    Node node = lastNodeOf(s);
    return node != null && node.terminal;
  }

  public boolean hasPrefix(CharSequence s) {
    Node node = lastNodeOf(s);
    return node != null;
  }

}

enum Direction {
  RIGHT {
    @Override
    int nr(int r) {
      return r;
    }

    @Override
    int nc(int c) {
      return c + 1;
    }

    @Override
    Direction[] orthogonal() {
      return new Direction[] {DOWN, UP};
    }
  },
  DOWN {
    @Override
    int nr(int r) {
      return r + 1;
    }

    @Override
    int nc(int c) {
      return c;
    }

    @Override
    Direction[] orthogonal() {
      return new Direction[] {RIGHT, LEFT};
    }
  },
  LEFT {
    @Override
    int nr(int r) {
      return r;
    }

    @Override
    int nc(int c) {
      return c - 1;
    }

    @Override
    Direction[] orthogonal() {
      return new Direction[] {DOWN, UP};
    }
  },
  UP {
    @Override
    int nr(int r) {
      return r - 1;
    }

    @Override
    int nc(int c) {
      return c;
    }

    @Override
    Direction[] orthogonal() {
      return new Direction[] {RIGHT, LEFT};
    }
  };

  abstract int nr(int r);
  abstract int nc(int c);

  abstract Direction[] orthogonal();

}

/** */
public class AngularWords {
  public static void main(String[] args) throws IOException {
    try (Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out)) {
      int n = scanner.nextInt();
      int m = scanner.nextInt();
      scanner.nextLine();
      String s = scanner.nextLine();
      char[][] board = new char[n][];
      for (int i = 0; i < n; i++) {
        String line = scanner.nextLine();
        board[i] = line.toCharArray();
      }

      int solution = solve(board, s);
      writer.println(solution);
    }
  }

  static int solve(char[][] board, String s) {
    int n = board.length;
    int m = board[0].length;

    Trie trie = new Trie();
    trie.add(s);

    int counter = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        StringBuilder sb = new StringBuilder(n + m);
        sb.append(board[i][j]);
        if (!trie.hasPrefix(sb)) {
          continue;
        }
        counter += dfs(board, trie, sb, null, false, i, j);
      }
    }

    return counter;
  }

  private static int dfs(char[][] board, Trie trie, StringBuilder sb,
      Direction d, boolean rotated, int i, int j) {
    if (trie.hasWord(sb)) {
      return 1;
    }
    int counter = 0;

    int n = board.length;
    int m = board[0].length;
    if (d == null) {
      for (Direction direction : Direction.values()) {
        int nr = direction.nr(i);
        int nc = direction.nc(j);

        if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
          continue;
        }

        sb.append(board[nr][nc]);
        if (trie.hasPrefix(sb)) {
          counter += dfs(board, trie, sb, direction, rotated, nr, nc);
        }
        sb.deleteCharAt(sb.length() - 1);
      }
    } else {
      int nr = d.nr(i);
      int nc = d.nc(j);

      if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
        sb.append(board[nr][nc]);
        if (trie.hasPrefix(sb)) {
          counter += dfs(board, trie, sb, d, rotated, nr, nc);
        }
        sb.deleteCharAt(sb.length() - 1);
      }

      if (!rotated) {
        for (Direction direction : d.orthogonal()) {
          nr = direction.nr(i);
          nc = direction.nc(j);

          if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
            continue;
          }

          sb.append(board[nr][nc]);
          if (trie.hasPrefix(sb)) {
            counter += dfs(board, trie, sb, direction, true, nr, nc);
          }
          sb.deleteCharAt(sb.length() - 1);
        }
      }
    }

    return counter;
  }
}
