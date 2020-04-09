package algorithms.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SumSubset {

    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 3, 1, 4};
        int sum = 31;

        List<Stack<Integer>> result = new ArrayList<>();
        Stack<Integer> buffer = new Stack<>();

        getSubsetSumArray(array, sum, array.length - 1, buffer, result);
        /*not sure why not working*/
        for (Stack<Integer> temp : result) {
            while (!temp.isEmpty()) {
                System.out.println("===========");
                System.out.print(temp.pop() + "\t");
            }
            System.out.println();
        }
        getSubsetSumArrayDP(array, sum);
    }

    private static void getSubsetSumArrayDP(int[] array, int sum) {
        int len = array.length;
        boolean[][] memo = new boolean[len + 1][sum + 1];

        for (int i = 0; i < len + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (j == 0) {
                    memo[i][j] = true;
                    continue;
                }

                if (i == 0) {
                    memo[i][j] = false;
                    continue;
                }


                if (array[i - 1] <= j) {
                    memo[i][j] = memo[i - 1][j] || memo[i - 1][j - array[i - 1]];

                } else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }
        System.out.println("Does the array contain subarray that has sum " + sum + " :" + memo[len][sum]);
    }

    private static boolean getSubsetSumArray(int[] array, int sum, int index, Stack<Integer> buffer, List<Stack<Integer>> result) {
        if (index == 0) return false;

        if (sum == 0) {
            result.add(buffer);
            return true;
        }
        if (sum - array[index] >= 0) {

            buffer.push(array[index]);
            boolean with = getSubsetSumArray(array, sum - array[index], index - 1, buffer, result);
            buffer.pop();
            boolean without = getSubsetSumArray(array, sum, index - 1, buffer, result);

            return with || without;
        } else {
            return getSubsetSumArray(array, sum, index - 1, buffer, result);
        }
    }
}
