package algorithms.Recursion;

public class AllPossibleCombinationOfLengthN {

    public static void main(String[] args) {
        int[] input = new int[]{2, 4, 5, 1, 7, 8};

        int N = 5;
        int[] bufferedArray = new int[N];
        printAllCombination(input, bufferedArray, 0, 0);
    }

    private static void printAllCombination(int[] input, int[] bufferedArray, int index, int bufferIndex) {
        if (bufferIndex == bufferedArray.length) {
            print(bufferedArray);
            return;
        }

        if (index == input.length) {
            return;
        }

        for (int i = index; i < input.length; i++) {
            bufferedArray[bufferIndex] = input[i];

            printAllCombination(input, bufferedArray, i + 1, bufferIndex + 1);
        }

    }

    private static void print(int[] bufferedArray) {
        for (int value : bufferedArray) {
            System.out.print(value + "\t");
        }

        System.out.println("\n");
    }
}
