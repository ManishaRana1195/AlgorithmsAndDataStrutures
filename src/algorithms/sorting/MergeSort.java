package algorithms.sorting;

public class MergeSort {


  public static void main(String[] args) {
    int inputArray[] = {39, 68, 23, 90, 45, 67, 12, 6, 67, 79};

    int low = 0;
    int high = inputArray.length;
    divideArray(inputArray, low, high - 1);
    for (int val : inputArray) {
      System.out.print(val + "   ");
    }
  }

  private static void divideArray(int[] inputArray, int low, int high) {
    if (high <= low) return;
    int mid = low + (high - low) / 2;
    divideArray(inputArray, low, mid);
    divideArray(inputArray, mid + 1, high);
    mergeArray(inputArray, low, mid, high);
  }

  private static void mergeArray(int[] input, int low, int mid, int high) {
    int[] tempArrayA = new int[mid - low + 1];
    int[] tempArrayB = new int[high - mid];

    int k = 0;
    for (int i = low; i <= mid; i++, k++) {
      tempArrayA[k] = input[i];
    }

    k = 0;
    for (int i = mid + 1; i <= high; i++, k++) {
      tempArrayB[k] = input[i];
    }

    int len1 = tempArrayA.length, len2 = tempArrayB.length;
    int i = 0, j = 0;
    k = low;
    while (i < len1 && j < len2) {
      if (tempArrayA[i] > tempArrayB[j]) {
        input[k] = tempArrayB[j++];
        k++;
      } else {
        input[k] = tempArrayA[i++];
        k++;
      }
    }

    while (i < len1) {
      input[k++] = tempArrayA[i++];
    }

    while (j < len2) {
      input[k++] = tempArrayB[j++];
    }
  }
}
