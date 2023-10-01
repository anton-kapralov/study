package kae.coding.algorithms.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** */
public class Subsets {

  private final List<List<Integer>> subsets = new ArrayList<>();

  private final int n;

  public Subsets(int n) {
    this.n = n;
    search(0, new LinkedList<>());
  }

  private void search(int k, LinkedList<Integer> subset) {
    if (k == n) {
      subsets.add(new ArrayList<>(subset));
      return;
    }

    subset.addLast(k);
    search(k + 1, subset);
    subset.removeLast();
    search(k + 1, subset);
  }

  public List<List<Integer>> asList() {
    return subsets;
  }
}
