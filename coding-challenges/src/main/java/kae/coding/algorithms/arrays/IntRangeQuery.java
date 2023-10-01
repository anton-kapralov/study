package kae.coding.algorithms.arrays;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class IntRangeQuery {

  private final IntBinaryOperator operator;
  private final int identity;
  private final int[] tree;
  private final int n;

  public IntRangeQuery(int[] nums, IntBinaryOperator operator, int identity) {
    this.operator = operator;
    this.identity = identity;

    int sizePow2 = 1;
    //noinspection StatementWithEmptyBody
    for (; sizePow2 < nums.length; sizePow2 <<= 1)
      ;

    n = sizePow2;

    this.tree = new int[2 * n];

    System.arraycopy(nums, 0, tree, n, nums.length);
    Arrays.fill(tree, n + nums.length, tree.length, identity);

    for (int i = n - 1; i > 0; --i) {
      tree[i] = operator.applyAsInt(tree[i * 2], tree[i * 2 + 1]);
    }
  }

  public int get(int l, int r) {
    l += n;
    r += n;

    int result = identity;

    while (l <= r) {
      if (l % 2 == 1) {
        // l is right child => out of range, so adding to the result.
        result = operator.applyAsInt(result, tree[l++]);
      }

      if (r % 2 == 0) {
        // r is left child => out of range, so adding to the result.
        result = operator.applyAsInt(result, tree[r--]);
      }

      l /= 2;
      r /= 2;
    }

    return result;
  }

  public void update(int i, int v) {
    i += n;

    tree[i] = v;

    i /= 2;
    while (i > 0) {
      tree[i] = operator.applyAsInt(tree[i * 2], tree[i * 2 + 1]);
      i /= 2;
    }
  }
}
