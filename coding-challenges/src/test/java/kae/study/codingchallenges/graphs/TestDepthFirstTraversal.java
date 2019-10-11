package kae.study.codingchallenges.graphs;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

class TestDepthFirstTraversal {

  @Test
  void testTraverseTree() {
    Node<Integer> root =
        new Node<>(
            1,
            Arrays.asList(
                new Node<>(
                    2,
                    Arrays.asList(
                        new Node<>(5, Arrays.asList(new Node<>(9), new Node<>(10))),
                        new Node<>(6))),
                new Node<>(3),
                new Node<>(
                    4,
                    Arrays.asList(
                        new Node<>(7, Arrays.asList(new Node<>(11), new Node<>(12))),
                        new Node<>(8)))));

    final List<Integer> result = new LinkedList<>();
    DepthFirstTraversal.traverse(root, node -> result.add(node.getValue()));

    System.out.println(result);
      assertThat(result).isEqualTo(List.of(1, 4, 8, 7, 12, 11, 3, 2, 6, 5, 10, 9));
  }

  @Test
  void testTraverseCyclicGraph() {
    Node<Integer> first = new Node<>(1);
    Node<Integer> forth = new Node<>(4);
    Node<Integer> root =
        new Node<>(0, List.of(new Node<>(2, List.of(first)), new Node<>(3, List.of(forth))));

    first.getLinkedNodes().add(root);
    forth.getLinkedNodes().add(root);

    final List<Integer> result = new LinkedList<>();
    DepthFirstTraversal.traverse(root, node -> result.add(node.getValue()));

    System.out.println(result);
      assertThat(result).isEqualTo(List.of(0, 3, 4, 2, 1));
  }
}
