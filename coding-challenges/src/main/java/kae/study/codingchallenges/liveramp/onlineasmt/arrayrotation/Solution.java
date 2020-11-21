package kae.study.codingchallenges.liveramp.onlineasmt.arrayrotation;

/**
 *
 */
class Solution {
  public int[] solution(int[] a, int k) {
    int n = a.length;
    if (n == 0) {
      return a;
    }

    k = k % n;
    if (k == 0) {
      return a;
    }

    int[] result = new int[n];
    System.arraycopy(a, 0, result, k, n - k);
    System.arraycopy(a, n - k, result, 0, k);

    return result;
  }
}
