package datastructures.arrays;

import java.util.PriorityQueue;

public class KMessedArray {

    public static void main(String[] args) {
        int[] arrayInput = {1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
        int k = 2;
        sortKMessedArray(arrayInput, k);
        for (int value : arrayInput) {
            System.out.println(value);
        }
    }

    private static void sortKMessedArray(int[] arrayInput, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1);
        for (int i = 0; i < k + 1; i++) {
            heap.add(arrayInput[i]);
        }

        int len = arrayInput.length;
        for (int i = 0; i < len; i++) {
            arrayInput[i] = heap.poll();
            if (i + k + 1 < len) {
                heap.add(arrayInput[i + k + 1]);
            }
        }
    }
}
