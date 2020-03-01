package algorithms.Recursion;

public class AllSubsets {

    public static void main(String[] args) {
        int[] input = new int[]{2, 4, 5, 1};

        int[] buffer = new int[input.length];
        printAllSubsets(input, buffer, 0, 0);
    }

    private static void printAllSubsets(int[] input, int[] buffer, int index, int bufferIndex) {
        print(buffer, bufferIndex);

        // base condition
        if (bufferIndex == buffer.length) return;
        if (index == input.length) return;

        for (int i = index; i < input.length; i++) {
            // chose the next candidate
            buffer[bufferIndex] = input[i];

            // recurse to next index
            printAllSubsets(input, buffer, i + 1, bufferIndex + 1);
        }
    }

    private static void print(int[] buffer, int bufferIndex) {
        for (int i = 0; i < bufferIndex; i++) {
            System.out.print(buffer[i] + "\t");
        }
        System.out.println("\n");
    }

}
