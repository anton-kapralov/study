package kae.study.codingchallenges.graphs;

import java.util.*;
import java.util.function.Consumer;

public class DepthFirstTraversal {

  public static <T> void traverse(Node<T> root, Consumer<Node<T>> consumer) {
    if (root == null) {
      return;
    }

    Deque<Node<T>> deque = new LinkedList<>();
    Set<Node<T>> visited = new HashSet<>();

    deque.push(root);

    while (!deque.isEmpty()) {
      final Node<T> node = deque.pop();
      Objects.requireNonNull(node);

      if (visited.contains(node)) {
        continue;
      }

      consumer.accept(node);
      visited.add(node);

      for (Node<T> linkedNode : node.getLinkedNodes()) {
        if (!visited.contains(linkedNode)) {
          deque.push(linkedNode);
        }
      }
    }
  }

}
