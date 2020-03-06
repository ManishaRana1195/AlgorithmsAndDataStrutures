package algorithms.Recursion;

import java.util.Stack;

// you should find combination of coin values that sum up to target
public class CoinChangePrintProblem {

    public static void main(String[] args) {
        int[] dimensions = new int[]{1, 2, 5};

        int sum = 5;
        // use stack to avoid succeeding zeros in the result
        Stack<Integer> buffer = new Stack<>();
        getAllCoinCombination(dimensions, buffer, 0, sum);
    }

    private static void getAllCoinCombination(int[] dimensions, Stack<Integer> buffer, int startIndex, int sum) {
        if (sum < 0) {
            return;
        }

        if (sum == 0) {
            print(buffer);
            return;
        }

        for (int i = startIndex; i < dimensions.length; i++) {
            buffer.push(dimensions[i]);
            getAllCoinCombination(dimensions, buffer, i, sum - dimensions[i]);
            buffer.pop();
        }
    }

    private static void print(Stack<Integer> buffer) {
        for (int value : buffer) {
            System.out.print(value);
        }
        System.out.println();
    }
}
