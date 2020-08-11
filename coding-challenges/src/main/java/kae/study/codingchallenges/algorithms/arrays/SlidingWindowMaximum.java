package kae.study.codingchallenges.algorithms.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 */
public class SlidingWindowMaximum {

  private final int[] nums;
  private final int k;
  private int r;
  private final Deque<Integer> deque;

  SlidingWindowMaximum(int[] nums, int k) {
    this.nums = nums;
    this.k = k;
    deque = new ArrayDeque<>(k);

    for (; r < k && r < this.nums.length; ++r) {
      add(nums[r]);
    }
  }

  boolean canMove() {
    return r < nums.length;
  }

  void move() {
    if (!canMove()) {
      return;
    }
    remove(nums[r - k]);
    add(nums[r++]);
  }

  int getMax() {
    return deque.getFirst();
  }

  void add(int x) {
    while (!deque.isEmpty() && deque.getLast() < x) {
      deque.removeLast();
    }

    deque.addLast(x);
  }

  void remove(int x) {
    if (x == deque.getFirst()) {
      deque.removeFirst();
    }
  }

}
