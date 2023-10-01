package kae.coding.algorithms.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** */
public class Permutations {

  private final List<List<Integer>> permutations = new ArrayList<>();

  private final int n;

  public Permutations(int n) {
    this.n = n;
    search(new LinkedList<>(), new boolean[n]);
  }

  private void search(LinkedList<Integer> permutation, boolean[] chosen) {
    if (permutation.size() == n) {
      permutations.add(new ArrayList<>(permutation));
      return;
    }

    for (int i = 0; i < n; i++) {
      if (chosen[i]) {
        continue;
      }

      permutation.addLast(i);
      chosen[i] = true;
      search(permutation, chosen);
      permutation.removeLast();
      chosen[i] = false;
    }
  }

  public List<List<Integer>> asList() {
    return permutations;
  }
}
