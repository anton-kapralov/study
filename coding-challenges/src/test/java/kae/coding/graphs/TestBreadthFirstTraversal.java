package kae.coding.graphs;

import static com.google.common.truth.Truth.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

class TestBreadthFirstTraversal {

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
    BreadthFirstTraversal.traverse(root, node -> result.add(node.getValue()));

    System.out.println(result);
    assertThat(result).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
  }

  @Test
  void testTraverseCyclicGraph() {
    final Node<Integer> ninthNode = new Node<>(9);
    final Node<Integer> tenth = new Node<>(10);
    final Node<Integer> third = new Node<>(3);
    final Node<Integer> eleventh = new Node<>(11);
    Node<Integer> root =
        new Node<>(
            1,
            Arrays.asList(
                new Node<>(
                    2,
                    Arrays.asList(
                        new Node<>(5, Arrays.asList(ninthNode, tenth)), new Node<>(6), third)),
                third,
                new Node<>(
                    4,
                    Arrays.asList(
                        new Node<>(7, Arrays.asList(eleventh, new Node<>(12))), new Node<>(8)))));

    ninthNode.getLinkedNodes().addAll(Arrays.asList(root, tenth));
    third.getLinkedNodes().add(eleventh);
    eleventh.getLinkedNodes().add(third);

    final List<Integer> result = new LinkedList<>();
    BreadthFirstTraversal.traverse(root, node -> result.add(node.getValue()));

    System.out.println(result);
    assertThat(result).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6, 11, 7, 8, 9, 10, 12));
  }
}
