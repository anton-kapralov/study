package kae.coding.algorithms.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/** */
class BoundedTriplets {

  static Set<Set<Integer>> findTriplets(int[] input, int bound) {
    Arrays.sort(input);

    Set<Set<Integer>> result = new HashSet<>();
    for (int i = 0; i < input.length - 2; i++) {
      int j = i + 1;
      int k = input.length - 1;
      while (j < k) {
        if (input[i] + input[j] + input[k] > bound) {
          k--;
        } else {
          for (int l = j + 1; l <= k; l++) {
            result.add(Set.of(input[i], input[j], input[l]));
          }
          j++;
        }
      }
    }

    System.out.println(result);

    return result;
  }
}
