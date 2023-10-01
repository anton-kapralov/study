package kae.coding.algorithms.sorting;

/** */
public class QuickSort implements IntArraySort {

  @Override
  public void sort(int[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  private static void sort(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }

    int pivot = partition(arr, left, right);
    sort(arr, left, pivot - 1);
    sort(arr, pivot + 1, right);
  }

  private static int partition(int[] arr, int left, int right) {
    int i = left - 1;

    int pivot = arr[right];

    for (int j = left; j < right; ++j) {
      if (arr[j] < pivot) {
        i++;

        swap(arr, i, j);
      }
    }

    swap(arr, i + 1, right);

    return i + 1;
  }

  private static void swap(int[] arr, int i, int j) {
    if (i == j) {
      return;
    }
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  @Override
  public String toString() {
    return QuickSort.class.getSimpleName();
  }
}
