package kae.study.codingchallenges.algorithms.binarytrees;

import kae.study.codingchallenges.datastructures.BinaryTreeNode;

public interface BinaryTreeIterator {

  boolean hasNext();

  BinaryTreeNode next();
}
