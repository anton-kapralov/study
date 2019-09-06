package kae.study.codingchallenges.algorithms.sorting.tutorialintro;

import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int v = Integer.parseInt(in.nextLine());
    int n = Integer.parseInt(in.nextLine());
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }

    int idx = getIdx(v, n, arr);

    System.out.println(idx);
  }

  private static int getIdx(int v, int n, int[] arr) {
    int start = 0;
    int end = n;

    for (int i = 0; i < n; i++) {
      int idx = (start + end) / 2;
      int num = arr[idx];
      if (v == num) {
        return idx;
      }

      if (start == end) {
        break;
      }

      if (v < num) {
        end = idx;
      } else {
        start = idx;
      }
    }

    return -1;
  }
}
