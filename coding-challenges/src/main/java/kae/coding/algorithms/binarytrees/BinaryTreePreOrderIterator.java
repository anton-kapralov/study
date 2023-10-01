package kae.coding.algorithms.binarytrees;

import java.util.ArrayDeque;
import java.util.Deque;
import kae.coding.datastructures.BinaryTreeNode;

public class BinaryTreePreOrderIterator implements BinaryTreeIterator {

  private final Deque<BinaryTreeNode> dq = new ArrayDeque<>();

  public BinaryTreePreOrderIterator(BinaryTreeNode root) {
    dq.addFirst(root);
  }

  @Override
  public boolean hasNext() {
    return !dq.isEmpty();
  }

  @Override
  public BinaryTreeNode next() {
    BinaryTreeNode node = dq.removeFirst();

    if (node.right() != null) {
      dq.addFirst(node.right());
    }

    if (node.left() != null) {
      dq.addFirst(node.left());
    }

    return node;
  }
}
