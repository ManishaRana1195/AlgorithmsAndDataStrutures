package algorithms.DynamicProgramming;

import java.util.Arrays;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 1};
        int sum = Arrays.stream(array).sum();
        if (sum % 2 != 0) {
            System.out.println("2 partition with equal sum is possible? false");
            return; // false
        }
        boolean isPossible = isEqualSumPartitionPossible(array, array.length - 1, sum / 2);
        System.out.println("2 partition with equal sum is possible? " + isPossible);
    }

    private static boolean isEqualSumPartitionPossible(int[] array, int index, int sum) {
        if (index == 0) return false;

        if (sum == 0) {
            return true;
        }

        if (sum - array[index] >= 0) {
            boolean with = isEqualSumPartitionPossible(array, index - 1, sum - array[index]);
            boolean without = isEqualSumPartitionPossible(array, index - 1, sum);
            return with || without;
        } else {
            return isEqualSumPartitionPossible(array, index - 1, sum);
        }
    }
}
