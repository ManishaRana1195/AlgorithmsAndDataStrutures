package algorithms.arrays;

public class TraverseFromEnds {

    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 5, 2, 6, 4, 7, 8, 9};
        int[] subarray = getUnsortedArray(input);
        printResult(input, subarray);

        input = new int[]{1, 3, 7, 6, 5, 8, 10, 9, 11};
        subarray = getUnsortedArray(input);
        printResult(input, subarray);

    }

    private static void printResult(int[] input, int[] subarray) {
        System.out.println("Indices of unsorted array: " + subarray[0] + "\t" + subarray[1]);
        System.out.println("Subarray is unsorted: from " + input[subarray[0]] + " to " + input[subarray[1]]);
    }

    private static int[] getUnsortedArray(int[] input) {
        int low = 0;
        int len = input.length - 1;
        int high = len;

        int dip = -1, bump = -1;
        // find the first dip
        while (low <= len) {
            if (input[low] > input[low + 1]) {
                dip = low + 1;
                break;
            }
            low += 1;
        }

        // no dip, that means array is sorted
        if (dip == -1) return new int[]{-1, -1};

        // find the first bump from the end
        while (high > 0) {
            if (input[high] < input[high - 1]) {
                bump = high;
                break;
            }
            high -= 1;
        }

        // find minimum and maximum in the array
        // so as to expand on left and right to find values that
        // are not in order on left and right
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = dip; i < high; i++) {
            if (min > input[i]) {
                min = input[i];
            }

            if (max < input[i]) {
                max = input[i];
            }
        }

        // continue to move left to find the unsorted index
        int temp = min;
        while (input[dip - 1] > temp) {
            dip -= 1;
        }

        // continue to move right to find the unsorted index
        temp = max;
        while (temp > input[bump + 1]) {
            bump += 1;
        }

        return new int[]{dip, bump};
    }
}
