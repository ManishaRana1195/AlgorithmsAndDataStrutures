package datastructures.arrays;

public class PartitionArray {

    public static void main(String[] args) {
        int[] input = new int[]{0, 2, 1, 0, 3, 3, 0};
        int[] inputA = new int[]{5, 2, 4, 4, 6, 4, 4, 3, 6};
        int[] inputB = new int[]{1, 0, 1, 2, 1, 0, 1, 2, 0, 2, 1, 2, 2};

        moveZerosToFront(input);
        print(input);
        moveZerosToEnd(input);
        print(input);

        partitionIntoThree(inputA, 4);
        print(inputA);

        partitionIntoThree(inputB, 1);
        print(inputB);

    }

    private static void partitionIntoThree(int[] inputA, int pivot) {
        int boundaryFront = 0;
        int boundaryEnd = inputA.length - 1;

        int i = 0;
        while (i <= boundaryEnd) {
            if (inputA[i] < pivot) {
                swap(i, boundaryFront, inputA);
                boundaryFront++;
                i++;
            } else if (inputA[i] > pivot) {
                swap(i, boundaryEnd, inputA);
                boundaryEnd--;
            } else {
                i++;
            }
        }
    }

    private static void moveZerosToEnd(int[] input) {
        int len = input.length - 1;
        int boundary = len;

        for (int i = len; i >= 0; i--) {
            if (input[i] == 0) {
                swap(i, boundary, input);
                boundary--;
            }
        }
    }

    private static void print(int[] input) {
        for (int anInput : input) {
            System.out.print(anInput + "\t");
        }

        System.out.println("\n");
    }

    private static void moveZerosToFront(int[] input) {
        int boundary = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 0) {
                swap(i, boundary, input);
                boundary++;
            }
        }
    }

    private static void swap(int i, int boundary, int[] input) {
        int temp = input[i];
        input[i] = input[boundary];
        input[boundary] = temp;
    }
}
