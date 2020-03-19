package kae.study.codingchallenges.algorithms.sorting;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

/** */
public class QuickSortTest {

  private final QuickSort quickSort = new QuickSort();

  @Test
  public void sort_doNotChangeEmpty() {
    int[] arr = {};

    quickSort.sort(arr);

    assertThat(arr).isEqualTo(new int[0]);
  }

  @Test
  public void sort_doNotChangeOneSized() {
    int[] arr = {1};

    quickSort.sort(arr);

    assertThat(arr).isEqualTo(new int[] {1});
  }

  @Test
  public void sort_doNotChangeAlreadySorted() {
    int[] arr = {1, 2, 3};

    quickSort.sort(arr);

    assertThat(arr).isEqualTo(new int[] {1, 2, 3});
  }

  @Test
  public void sort_whenPeakInFirstHalf() {
    int[] arr = {3, 10, 4, 9, 8, 7};

    quickSort.sort(arr);

    assertThat(arr).isEqualTo(new int[] {3, 4, 7, 8, 9, 10});
  }

  @Test
  public void sort_whenFirstHalfSorted() {
    int[] arr = {3, 4, 5, 9, 8, 7};

    quickSort.sort(arr);

    assertThat(arr).isEqualTo(new int[] {3, 4, 5, 7, 8, 9});
  }

  @Test
  public void sort_whenSortedInDecreasingOrder() {
    int[] arr = {6, 5, 4, 3, 2, 1};

    quickSort.sort(arr);

    assertThat(arr).isEqualTo(new int[] {1, 2, 3, 4, 5, 6});
  }
}
