package algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayIntersection {

  public static void main(String[] args) {
    int[] arrayA = {90, 80, 40, 60, 50, 30, 10, 70};
    int[] arrayB = {30, 70, 10, 50, 11, 33, 83, 47};
    int[] arrayC = {20, 90, 11, 83, 30, 10, 50, 70};
    ArrayList<Integer> result = new ArrayList<>();

    Arrays.sort(arrayA);
    Arrays.sort(arrayB);
    Arrays.sort(arrayC);

    int x, y, z = 0;
    for (x = 0, y = 0, z = 0; x < arrayA.length && y < arrayB.length && z < arrayC.length; ) {
      if (arrayA[x] == arrayB[y] && arrayB[y] == arrayC[z]) {
        result.add(arrayA[x]);
        x++;
        y++;
        z++;
      } else if (arrayA[x] < arrayB[y]) {
        x++;
      } else if (arrayB[y] < arrayC[z]) {
        y++;
      } else {
        z++;
      }
    }

    System.out.println(result);
  }

}
