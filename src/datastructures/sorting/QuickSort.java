package datastructures.sorting;

public class QuickSort {


    public static void main(String[] args) {
        int inputArray[] = {39, 68, 23, 90, 45, 67, 12, 6, 67, 79};

        quicksort(inputArray, 0, inputArray.length - 1);
        for (int val : inputArray) {
            System.out.println(val);
        }

    }

    private static void quicksort(int[] inputArray, int low, int high) {
        if (low >= high) return;

        int partitionIndex = getPartitionIndex(inputArray, low, high);

        quicksort(inputArray, low, partitionIndex-1);
        // not include pivot, as it is already
        // sorted and is at correct position
        quicksort(inputArray, partitionIndex+1, high);
    }

    private static int getPartitionIndex(int[] inputArray, int low, int high) {
        int partitionIndex = low;
        int pivot = inputArray[high];

        for (int i = low; i < high; i++) {
            if (inputArray[i] < pivot) {
                swap(i, partitionIndex, inputArray);
                partitionIndex++;
            }
        }

        swap(partitionIndex, high, inputArray);
        return partitionIndex;
    }

    private static void swap(int index, int indexY, int[] inputArray) {
        int temp = inputArray[index];
        inputArray[index] = inputArray[indexY];
        inputArray[indexY] = temp;
    }


}
