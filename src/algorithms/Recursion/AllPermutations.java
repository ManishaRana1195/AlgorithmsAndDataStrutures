package algorithms.Recursion;

public class AllPermutations {

    public static void main(String[] args) {
        int[] input = new int[]{2, 4, 2};

        int[] buffer = new int[input.length];
        boolean[] isInBuffer = new boolean[input.length];

        printAllPermutations(input, buffer, isInBuffer, 0);

    }

    private static void printAllPermutations(int[] input, int[] buffer, boolean[] isInBuffer, int bufferIndex) {
        // break condition
        if (bufferIndex == buffer.length) {
            print(buffer);
            return;
        }

        // should start from 0, becoz a permutation can contain value from previous index as well
        for (int i = 0; i < input.length; i++) {
            // find the correct candidate
            if (isInBuffer[i]) continue;

            buffer[bufferIndex] = input[i];
            isInBuffer[i] = true;
            // move to next candidate
            printAllPermutations(input, buffer, isInBuffer, bufferIndex + 1);
            isInBuffer[i] = false;
        }
    }

    private static void print(int[] buffer) {
        for (int value : buffer) {
            System.out.print(value);
        }
        System.out.println();
    }
}
