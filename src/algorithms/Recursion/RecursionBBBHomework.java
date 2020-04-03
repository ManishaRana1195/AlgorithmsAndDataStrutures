package algorithms.Recursion;

import java.util.LinkedList;
import java.util.List;

public class RecursionBBBHomework {

    public static void main(String[] args) {
        printOdd(new int[]{2, 4, 6, 8, 10, 12}, 0);

        int[] input = new int[2];
        minMax(new int[]{4, 6, 2, 8, 1, 11, 3}, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, input);

        System.out.println("*************************");
        for (int val : input) {
            System.out.println(val);
        }

        System.out.println("************************");
        // flatten 2 D array
        int[][] matrix = {{1, 2, 3}, {4}, {5, 6}};
        int col = matrix[0].length;
        int row = matrix.length;
        int[] result = new int[row * col];
        flattenArrays(matrix, 0, 0, result);
        for (int element : result) {
            System.out.print(element + "\t");
        }

        System.out.println("************************");
        // String substring with recursion
        String s = "recusrion";
        List<String> substrings = new LinkedList<>();
        substringWithoutRecursion(s, substrings);
        for (String temp : substrings) {
            System.out.println(temp);
        }

        System.out.println("************************");
        substrings = new LinkedList<>();
        substringWithRecursion(s, 0, substrings);
        System.out.println("************************");


    }


    private static void substringWithRecursion(String s, int index, List<String> substrings) {
        if (index == s.length()) return;
        substringInner(s, index, index + 1, substrings);
        substringWithRecursion(s, index + 1, substrings);
    }

    private static void substringInner(String s, int i, int j, List<String> substrings) {
        if (j == s.length()) return;
        substrings.add(s.substring(i, j));
        substringInner(s, i, j + 1, substrings);
    }

    private static void substringWithoutRecursion(String s, List<String> substrings) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                substrings.add(s.substring(i, j));
            }
        }

    }

    private static void flattenArrays(int[][] matrix, int i, int index, int[] result) {
        if (matrix.length == i) return;

        for (int j = 0; j < matrix[i].length; j++) {
            result[index++] = matrix[i][j];
        }

        flattenArrays(matrix, i + 1, index, result);
    }

    private static void minMax(int[] nums, int min, int max, int index, int[] input) {
        if (index == nums.length) {
            input[0] = min;
            input[1] = max;
            return;
        }

        min = Math.min(min, nums[index]);
        max = Math.max(max, nums[index]);
        minMax(nums, min, max, index + 1, input);
    }

    private static void printOdd(int[] nums, int index) {
        if (index == nums.length) return;

        if (index % 2 != 0) {
            System.out.println(nums[index]);
        }
        printOdd(nums, index + 1);
    }
}
