package kae.coding.algorithms.binarytrees;

import static com.google.common.truth.Truth.assertThat;

import java.util.ArrayList;
import java.util.List;
import kae.coding.datastructures.BinaryTreeNode;
import org.junit.Test;

public class BinaryTreePreOrderIteratorTest {

  @Test
  public void iteratesCorrectly_whenTreeIsComplete() {
    BinaryTreeNode root =
        new BinaryTreeNode(
            4,
            new BinaryTreeNode(2, new BinaryTreeNode(1), new BinaryTreeNode(3)),
            new BinaryTreeNode(6, new BinaryTreeNode(5), new BinaryTreeNode(7)));
    BinaryTreePreOrderIterator it = new BinaryTreePreOrderIterator(root);

    List<Integer> result = new ArrayList<>();
    while (it.hasNext()) {
      result.add(it.next().value());
    }

    assertThat(result).isEqualTo(List.of(4, 2, 1, 3, 6, 5, 7));
  }

  @Test
  public void iteratesCorrectly_whenTreeIsInComplete() {
    BinaryTreeNode root =
        new BinaryTreeNode(
            4,
            new BinaryTreeNode(1, null, new BinaryTreeNode(3, new BinaryTreeNode(2), null)),
            new BinaryTreeNode(7, new BinaryTreeNode(5, null, new BinaryTreeNode(6)), null));
    BinaryTreePreOrderIterator it = new BinaryTreePreOrderIterator(root);

    List<Integer> result = new ArrayList<>();
    while (it.hasNext()) {
      result.add(it.next().value());
    }

    assertThat(result).isEqualTo(List.of(4, 1, 3, 2, 7, 5, 6));
  }
}
