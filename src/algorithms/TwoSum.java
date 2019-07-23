package algorithms;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

  public static void main(String[] args) {
    int[] inputArray = {5, 11, 3, 6, 8, 20, 12};
    int sum = 11;
    HashMap<Integer, Integer> positionMap = new HashMap<>();
    for (int i = 0; i < inputArray.length; i++) {
      positionMap.put(inputArray[i], i + 1);
    }

    Arrays.sort(inputArray);

    int length = inputArray.length;
    int x = 0, y = 0;
    for (int i = 0, j = length - 1; i < length && j >= 0; ) {

      if (inputArray[i] + inputArray[j] > sum) {
        j -= 1;
      } else if (inputArray[i] + inputArray[j] < sum) {
        i += 1;
      } else if (inputArray[i] + inputArray[j] == sum) {
        x = inputArray[i];
        y = inputArray[j];
        break;
      }
    }

    System.out.println("The positions are " + positionMap.get(x) + " " + positionMap.get(y));
  }
}
