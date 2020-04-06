package algorithms.DynamicProgramming;

public class KnapSackProblem {

    public static void main(String[] args) {
        int capacity = 5;
        int[] weights = {2, 3, 1, 4};
        int[] profits = {4, 5, 3, 7};

        int maxProfit = getMaxProfitInKnapsack(weights, weights.length - 1, profits, capacity);
        System.out.println("Max profit: " + maxProfit);

        Integer[][] memo = new Integer[weights.length + 1][capacity + 1];
        maxProfit = getMaxProfitInKnapsackWithMemo(weights, weights.length - 1, profits, capacity, memo);
        System.out.println("Max profit: " + maxProfit);

        memo = new Integer[weights.length + 1][capacity + 1];
        maxProfit = getMaxProfitInKnapsackDP(weights, profits, memo);
        System.out.println("Max profit: " + maxProfit);
    }

    private static int getMaxProfitInKnapsackDP(int[] weights, int[] profits, Integer[][] memo) {
        // initialize
        int row = memo.length;
        int col = memo[0].length;
        System.out.println(row + "," + col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = 0;
                    continue;
                }
                if (j - weights[i - 1] >= 0) {
                    // i in memo maps to i-1 in weights and profits
                    memo[i][j] = Math.max(memo[i - 1][j], profits[i - 1] + memo[i - 1][j - weights[i - 1]]);
                } else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }

        return memo[row - 1][col - 1];
    }

    private static int getMaxProfitInKnapsackWithMemo(int[] weights, int index, int[] profits, int capacity, Integer[][] memo) {
        if (capacity <= 0 || index == 0) {
            return 0;
        }
        if (memo[index][capacity] != null) return memo[index][capacity];

        if (capacity - weights[index] >= 0) {
            int withCurrentWeight = profits[index] + getMaxProfitInKnapsackWithMemo(weights, index - 1, profits, capacity - weights[index], memo);
            int withoutCurrFruit = getMaxProfitInKnapsack(weights, index - 1, profits, capacity);

            memo[index][capacity] = Math.max(withCurrentWeight, withoutCurrFruit);
            return memo[index][capacity];
        } else {

            memo[index][capacity] = getMaxProfitInKnapsackWithMemo(weights, index - 1, profits, capacity, memo);
            return memo[index][capacity];
        }

    }

    private static int getMaxProfitInKnapsack(int[] weights, int index, int[] profits, int capacity) {
        if (capacity <= 0 || index == 0) {
            return 0;
        }

        if (capacity - weights[index] >= 0) {
            int withCurrentWeight = profits[index] + getMaxProfitInKnapsack(weights, index - 1, profits, capacity - weights[index]);
            int withoutCurrFruit = getMaxProfitInKnapsack(weights, index - 1, profits, capacity);
            return Math.max(withCurrentWeight, withoutCurrFruit);
        } else {

            return getMaxProfitInKnapsack(weights, index - 1, profits, capacity);
        }

    }
}
