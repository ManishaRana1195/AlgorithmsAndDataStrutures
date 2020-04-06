package datastructures.arrays;

public class MedianOf2Arrays {

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 5,6, 7};
        int[] num2 = new int[]{3, 8, 9};


        int length1 = num1.length;
        int length2 = num2.length;
        int total = length1 + length2;
        if (length1 == 0) {
            getMedian(num2, total);
        }

        if (length2 == 0) {
            getMedian(num1, total);
        }
        int[] temp = new int[total];
        mergeArrays(num1, num2, temp);
        getMedian(temp, total);
    }

    private static void getMedian(int[] num2, int total) {
        float median;

        if (total % 2 == 0) {
            int temp = total / 2;
            int a = num2[temp];
            int b = num2[temp - 1];
            median = (float) ((a + b) / 2.0);
        } else {
            median = num2[total/2];
        }

        System.out.println("The median is:" + median);
    }

    private static void mergeArrays(int[] num1, int[] num2, int[] temp) {
        int length1 = num1.length;
        int length2 = num2.length;

        int i = 0, j = 0, k = 0;
        while (i < length1 && j < length2) {
            if (num1[i] <= num2[j]) {
                temp[k++] = num1[i++];
            } else {
                temp[k++] = num2[j++];
            }
        }

        while (i < length1) {
            temp[k++] = num1[i++];
        }

        while (j < length2) {
            temp[k++] = num2[j++];
        }
    }
}
