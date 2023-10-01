package kae.coding.algorithms.binarytrees;

import java.util.ArrayDeque;
import java.util.Deque;
import kae.coding.datastructures.BinaryTreeNode;

public class BinaryTreeInOrderIterator implements BinaryTreeIterator {

  private final Deque<BinaryTreeNode> dq = new ArrayDeque<>();

  public BinaryTreeInOrderIterator(BinaryTreeNode root) {
    stackLefts(root);
  }

  private void stackLefts(BinaryTreeNode node) {
    while (node != null) {
      dq.addFirst(node);
      node = node.left();
    }
  }

  @Override
  public boolean hasNext() {
    return !dq.isEmpty();
  }

  @Override
  public BinaryTreeNode next() {
    BinaryTreeNode node = dq.removeFirst();
    stackLefts(node.right());
    return node;
  }
}
