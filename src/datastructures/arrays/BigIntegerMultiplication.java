package datastructures.arrays;

public class BigIntegerMultiplication {

    public static void main(String[] args) {
        int inputA[] = {3, 2, 4};
        int inputB[] = {1, 1, 9};
        int lenA = inputB.length;
        int lenB = inputB.length;
        int zeroCount = 0;
        int result[] = new int[lenA];

        for (int i = lenB - 1; i >= 0; i--) {
            int carry = 0;
            int[] temp = new int[lenA + 1 + zeroCount];
            zeroCount += 1;
            for (int j = lenA - 1; j >= 0; j--) {
                int ans = inputA[i] * inputB[j] + carry;
                int sum = ans % 10;
                carry = ans / 10;
                temp[j + 1] = sum;
            }
            temp[0] = carry;
            result = add(result, temp);
        }

    }

    private static int[] add(int[] result, int[] temp) {
        // add 2 arrays
        return new int[0];
    }
}
