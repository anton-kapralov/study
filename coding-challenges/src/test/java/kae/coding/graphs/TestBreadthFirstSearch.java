package kae.coding.graphs;

import java.util.Arrays;
import org.junit.Test;

public class TestBreadthFirstSearch {

  @Test
  void testSearchCyclicGraph() {
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
    third.getLinkedNodes().add(ninthNode);
    eleventh.getLinkedNodes().add(third);

    System.out.println(BreadthFirstSearch.search(root, ninthNode));
  }
}
