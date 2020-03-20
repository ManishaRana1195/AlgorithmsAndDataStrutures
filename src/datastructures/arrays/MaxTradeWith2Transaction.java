package datastructures.arrays;

public class MaxTradeWith2Transaction {

    public static void main(String[] args) {
        int[] input = {3, 3, 5, 0, 0, 3, 1, 4};
        int len = input.length;

        int minSoFar = input[0];
        int maxTrade = 0;
        int[] profit_upto_i = new int[len];
        for (int i = 0; i < len; i++) {
            minSoFar = Math.min(input[i], minSoFar);
            maxTrade = Math.max(maxTrade, input[i] - minSoFar);
            profit_upto_i[i] = maxTrade;
        }

        int maxSoFar = input[len - 1];
        maxTrade = 0;
        int[] profit_from_i = new int[len + 1];
        profit_from_i[profit_from_i.length - 1] = 0;

        for (int i = len - 1; i >= 0; i--) {
            maxSoFar = Math.max(maxSoFar, input[i]);
            maxTrade = Math.max(maxTrade, maxSoFar - input[i]);
            profit_from_i[i] = maxTrade;
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            result = Math.max(result, profit_upto_i[i] + profit_from_i[i + 1]);
        }

        System.out.println("Max profit after 2 trades:" + result);
    }
}
