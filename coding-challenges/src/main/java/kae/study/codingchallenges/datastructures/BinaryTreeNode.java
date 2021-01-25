package kae.study.codingchallenges.datastructures;

import java.util.StringJoiner;

public class BinaryTreeNode {
  private int value;
  private BinaryTreeNode left;
  private BinaryTreeNode right;

  BinaryTreeNode(int value) {
    this.value = value;
  }

  public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public int value() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public BinaryTreeNode left() {
    return left;
  }

  public void setLeft(BinaryTreeNode left) {
    this.left = left;
  }

  public BinaryTreeNode right() {
    return right;
  }

  public void setRight(BinaryTreeNode right) {
    this.right = right;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", BinaryTreeNode.class.getSimpleName() + "[", "]")
        .add("val=" + value)
        .add("left=" + (left != null ? left.value : "null"))
        .add("right=" + (right != null ? right.value : "null"))
        .toString();
  }
}
