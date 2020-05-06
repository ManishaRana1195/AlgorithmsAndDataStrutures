package algorithms.arrays;

public class MaximumZerosByFlipping {

    public static void main(String[] args) {

        int[] input = new int[]{0, 1, 0, 0, 1, 1, 0};
        System.out.println("Maximum number of 0s that we can get by flipping:"
                + getMaximumZero(input));
    }

    private static int getMaximumZero(int[] input) {
        int maxCount = 0;
        int totalZeroCount = 0;

        for (int i = 0; i < input.length; i++) {
            int count1 = 0, count0 = 0;
            if (input[i] == 0) {
                totalZeroCount += 1;
            }
            for (int j = i; j < input.length; j++) {
                if (input[j] == 0) {
                    count0 += 1;
                } else {
                    count1 += 0;
                }
                maxCount = Math.max(maxCount, count1 - count0);
            }
        }
        return maxCount + totalZeroCount;
    }
}
