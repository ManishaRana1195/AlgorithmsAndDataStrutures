package algorithms.DynamicProgramming;

public class CountSubsetSum {

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 5, 6, 8, 10};
        int sum = 10;

        int count = 0;

        count = getCountOfSubsetsEqualToSum(array, sum, array.length - 1, count);
        System.out.println("The number of subsets equal to sum: " + count);

        count = getCountOfSubsetSum(array, sum);
        System.out.println("The number of subsets equal to sum: " + count);
    }

    private static int getCountOfSubsetsEqualToSum(int[] array, int sum, int index, int count) {
        if (index == 0) {
            if (sum == 0) {
                count++;
            }
            return count;
        }
        count = getCountOfSubsetsEqualToSum(array, sum - array[index], index - 1, count);
        count = getCountOfSubsetsEqualToSum(array, sum, index - 1, count);
        return count;
    }

    private static int getCountOfSubsetSum(int[] array, int sum) {
        int len = array.length;
        int[][] memo = new int[len + 1][sum + 1];

        for (int i = 0; i < len + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (j == 0) {
                    memo[i][j] = 1;
                    continue;
                }

                if (i == 0) {
                    memo[i][j] = 0;
                    continue;
                }


                if (array[i - 1] <= j) {
                    memo[i][j] = memo[i - 1][j] + memo[i - 1][j - array[i - 1]];

                } else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }
        return memo[len][sum];
    }

}
