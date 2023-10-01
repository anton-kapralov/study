package kae.coding.algorithms.binarytrees;

import static com.google.common.truth.Truth.assertThat;

import java.util.ArrayList;
import java.util.List;
import kae.coding.datastructures.BinaryTreeNode;
import org.junit.Test;

public class BinaryTreeInOrderIteratorTest {

  @Test
  public void iteratesCorrectly_whenTreeIsComplete() {
    BinaryTreeNode root =
        new BinaryTreeNode(
            4,
            new BinaryTreeNode(2, new BinaryTreeNode(1), new BinaryTreeNode(3)),
            new BinaryTreeNode(6, new BinaryTreeNode(5), new BinaryTreeNode(7)));
    BinaryTreeInOrderIterator it = new BinaryTreeInOrderIterator(root);

    List<Integer> result = new ArrayList<>();
    while (it.hasNext()) {
      result.add(it.next().value());
    }

    assertThat(result).isEqualTo(List.of(1, 2, 3, 4, 5, 6, 7));
  }

  @Test
  public void iteratesCorrectly_whenTreeIsInComplete() {
    BinaryTreeNode root =
        new BinaryTreeNode(
            4,
            new BinaryTreeNode(1, null, new BinaryTreeNode(3, new BinaryTreeNode(2), null)),
            new BinaryTreeNode(7, new BinaryTreeNode(5, null, new BinaryTreeNode(6)), null));
    BinaryTreeInOrderIterator it = new BinaryTreeInOrderIterator(root);

    List<Integer> result = new ArrayList<>();
    while (it.hasNext()) {
      result.add(it.next().value());
    }

    assertThat(result).isEqualTo(List.of(1, 2, 3, 4, 5, 6, 7));
  }
}
