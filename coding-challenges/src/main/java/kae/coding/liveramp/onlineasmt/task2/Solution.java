package kae.coding.liveramp.onlineasmt.task2;

import java.util.Arrays;

public class Solution {

  public int solution(int[] a, int k) {
    int n = a.length;
    if (n == 0 || k == 0) {
      return -1;
    }

    if (n < k) {
      return -1;
    }

    int max = -1;

    Arrays.sort(a);
    int sum = 0;
    int counter = 0;
    int evenSum = 0;
    int evenCounter = 0;

    for (int i = n - 1; i >= 0; i--) {
      sum += a[i];
      counter++;

      if (a[i] % 2 == 0 && evenCounter < k) {
        evenSum += a[i];
        evenCounter++;
        if (evenCounter == k) {
          max = Math.max(max, evenSum);
        }
      }

      if (counter == k) {
        if (sum % 2 == 0) {
          max = Math.max(max, sum);
          break;
        }
        sum -= a[i];
        counter--;
      }
    }

    return max;
  }
}
