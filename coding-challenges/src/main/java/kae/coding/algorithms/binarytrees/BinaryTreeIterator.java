package kae.coding.algorithms.binarytrees;

import kae.coding.datastructures.BinaryTreeNode;

public interface BinaryTreeIterator {

  boolean hasNext();

  BinaryTreeNode next();
}
