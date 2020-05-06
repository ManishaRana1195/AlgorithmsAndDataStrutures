package algorithms.arrays;

import java.util.Arrays;

public class MedianOfArray {

    public static void main(String[] args) {
        Integer[] input = {2, 1, 5, 2,7, 1, 4,6};

        Arrays.sort(input);
        float result = getMedianArray(input);
        System.out.println("Median of array is: " + result);
    }

    private static float getMedianArray(Integer[] input) {
        int len = input.length;
        float result;
        if (len % 2 == 0) {
            int indexA = len / 2;
            int indexB = (len - 1) / 2;
            result = (input[indexA] + input[indexB]) / 2;
        } else {
            result = input[(len) / 2];
        }

        return result;
    }
}
