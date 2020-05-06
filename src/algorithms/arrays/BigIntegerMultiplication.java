package algorithms.arrays;

import java.util.Arrays;

public class BigIntegerMultiplication {

    public static void main(String[] args) {
        int inputA[] = {3, 4};
        int inputB[] = {1, 5};
        int lenA = inputA.length;
        int lenB = inputB.length;
        int zeroCount = 0;
        int maxLength = Math.max(lenA, lenB) + 1;
        int result[] = new int[maxLength];

        for (int i = lenB - 1; i >= 0; i--) {
            int carry = 0;
            int[] temp = new int[maxLength + zeroCount];
            zeroCount += 1;
            for (int j = lenA - 1; j >= 0; j--) {
                int ans = inputA[i] * inputB[j] + carry;
                int sum = ans % 10;
                carry = ans / 10;
                temp[j + 1] = sum;
            }
            temp[0] = carry;
            result = add(temp, result);
        }

        System.out.println(Arrays.toString(result));

    }

    private static int[] add(int[] arrayA, int[] arrayB) {
        int i = arrayA.length - 1;
        int j = arrayB.length - 1;
        int carry = 0;
        int len = Math.max(i, j) + 1;
        int result[] = new int[len];
        int k = len - 1;

        while (i >= 0 && j >= 0) {
            int sum = arrayA[i] + arrayB[j] + carry;
            result[k] = sum % 10;
            carry = sum / 10;
            k--;
            i--;
            j--;
        }

        while (i >= 0) {
            int sum = arrayA[i] + carry;
            result[k] = sum % 10;
            carry = sum / 10;
            k--;
            i--;
        }

        while (j >= 0) {
            int sum = arrayB[j] + carry;
            result[k] = sum % 10;
            carry = sum / 10;
            k--;
            j--;
        }
        return result;
    }
}
