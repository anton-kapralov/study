package kae.coding.graphs;

import java.util.*;
import java.util.function.Consumer;

public class BreadthFirstTraversal {

  public static <T> void traverse(Node<T> root, Consumer<Node<T>> consumer) {
    if (root == null) {
      return;
    }

    Queue<Node<T>> queue = new LinkedList<>();
    Set<Node<T>> visited = new HashSet<>();

    queue.add(root);

    while (!queue.isEmpty()) {
      final Node<T> node = queue.poll();
      Objects.requireNonNull(node);

      if (visited.contains(node)) {
        continue;
      }

      consumer.accept(node);
      visited.add(node);

      for (Node<T> linkedNode : node.getLinkedNodes()) {
        if (!visited.contains(linkedNode)) {
          queue.add(linkedNode);
        }
      }
    }
  }
}
