package kae.study.codingchallenges.graphs;

import java.util.*;

public class BreadthFirstSearch {

  public static <T> List<Node<T>> search(Node<T> root, Node<T> sought) {
    if (root == null) {
      return Collections.emptyList();
    }

    Queue<Node<T>> queue = new LinkedList<>();
    Set<Node<T>> visited = new HashSet<>();
    Map<Node<T>, Node<T>> parentNodes = new HashMap<>();

    queue.add(root);

    while (!queue.isEmpty()) {
      final Node<T> node = queue.poll();
      Objects.requireNonNull(node);

      if (visited.contains(node)) {
        continue;
      }

      if (node.equals(sought)) {
        LinkedList<Node<T>> path = new LinkedList<>();
        path.add(node);

        Node<T> parent = node;
        while (null != (parent = parentNodes.get(parent))) {
          path.addFirst(parent);
        }

        return path;
      }
      visited.add(node);

      for (Node<T> linkedNode : node.getLinkedNodes()) {
        if (!visited.contains(linkedNode)) {
          parentNodes.putIfAbsent(linkedNode, node);
          queue.add(linkedNode);
        }
      }
    }

    return Collections.emptyList();
  }
}
