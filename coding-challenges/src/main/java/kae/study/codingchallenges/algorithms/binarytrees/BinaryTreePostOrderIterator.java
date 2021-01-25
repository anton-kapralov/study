package kae.study.codingchallenges.algorithms.binarytrees;

import java.util.ArrayDeque;
import java.util.Deque;
import kae.study.codingchallenges.datastructures.BinaryTreeNode;

/** */
public class BinaryTreePostOrderIterator implements BinaryTreeIterator {

  private final Deque<BinaryTreeNode> dq = new ArrayDeque<>();

  private BinaryTreeNode lastVisited;

  public BinaryTreePostOrderIterator(BinaryTreeNode root) {
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
    BinaryTreeNode node = dq.getFirst();
    if (lastVisited != node.right()) {
      while (node.right() != null) {
        stackLefts(node.right());
        node = dq.getFirst();
      }
    }
    return lastVisited = dq.removeFirst();
  }
}
