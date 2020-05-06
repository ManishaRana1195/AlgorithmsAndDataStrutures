package algorithms.arrays;

import java.util.Arrays;

/*Product of array except current index element*/
public class ProductOfArray {
  public static void main(String[] args) {
    int[] inputArray = {1, 2, 3, 4, 5};
    System.out.println("The product of the array except the current element:");
    Arrays.stream(getProductArray(inputArray)).forEach(System.out::println);
    System.out.println("================================");
    inputArray = new int[]{1, 2, 6, 5, 9};
    Arrays.stream(getProductArrayWithBetterComplexity(inputArray)).forEach(System.out::println);
  }

  /*With complexity O(N)*/
  private static int[] getProductArrayWithBetterComplexity(int[] inputArray) {
    int len = inputArray.length;
    int[] product_array_except_current_index = new int[len];
    int product_so_far = 1;
    product_array_except_current_index[0] = 1;
    for (int i = 1; i < len; i++) {
      product_array_except_current_index[i] = product_so_far;
      product_so_far *= inputArray[i - 1];
    }

    product_so_far = 1;
    for (int i = len - 1; i >= 0; i--) {
      product_array_except_current_index[i] *= product_so_far;
      product_so_far *= inputArray[i];
    }
    return product_array_except_current_index;
  }

  /*with complexity O(N2)*/
  private static int[] getProductArray(int[] inputArray) {
    int length = inputArray.length;
    int[] left = new int[length];
    int[] right = new int[length];
    int[] result = new int[length];

    left[0] = 1;
    right[length - 1] = 1;
    for (int i = 0; i < length; i++) {
      int temp = 1;
      for (int j = 0; j < i; j++) {
        temp *= inputArray[j];
      }
      left[i] = temp;
    }

    for (int i = 0; i < length; i++) {
      int temp = 1;
      for (int j = i + 1; j < length; j++) {
        temp *= inputArray[j];
      }
      right[i] = temp;
    }

    for (int i = 0; i < length; i++) {
      result[i] = left[i] * right[i];
    }
    return result;
  }


}
