package kae.study.codingchallenges.design;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Trie {

  static class Node {
    private final Map<Character, Node> children = new HashMap<>();
    private boolean terminal;
  }

  private final Node root = new Node();

  public void add(String s) {
    if (s.isEmpty()) {
      return;
    }

    Node node = root;
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      node = node.children.computeIfAbsent(c, ignored -> new Node());
    }
    node.terminal = true;
  }

  private Node lastNodeOf(String s) {
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

  public boolean hasWord(String s) {
    Node node = lastNodeOf(s);
    return node != null && node.terminal;
  }

  public boolean hasPrefix(String s) {
    Node node = lastNodeOf(s);
    return node != null;
  }

}
