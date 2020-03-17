package algorithms.DynamicProgramming;

public class DecodeWays {

    public static void main(String[] args) {
        String input = "2263";
        int pointer = 0;
        // recursion
        int numOfCombinations = getNumberOfValidCombination(input, pointer);
        System.out.println("Valid number of ways to decode " + input + " is: " + numOfCombinations);

        Integer[] memo = new Integer[input.length()];
        numOfCombinations = getNumberOfValidCombinationMemo(input, pointer, memo);
        System.out.println("Valid number of ways to decode " + input + " is: " + numOfCombinations);
    }

    private static int getNumberOfValidCombination(String input, int pointer) {
        int len = input.length();
        if (pointer >= len) return 1;

        int count = 0;

        /*run for loop up to 2 values, i+1 and i+2,
        * If substring of length 1 is valid, increment count and move to next substring of length 1
        * If substring of length 2 is valid, increment count and move to next substring of length 2*/

        for (int i = 1; i <= 2; i++) {
            if (pointer + i <= len) {
                String substring = input.substring(pointer, pointer + i);
                if (isValidCombination(substring)) {
                    count += getNumberOfValidCombination(input, pointer + i);
                }
            }
        }
        return count;
    }

    private static int getNumberOfValidCombinationMemo(String input, int pointer, Integer[] memo) {
        int len = input.length();
        if (pointer >= len) return 1;

        int count = 0;
        if (memo[pointer] != null) return memo[pointer];
        for (int i = 1; i <= 2; i++) {
            if (pointer + i <= len) {
                String substring = input.substring(pointer, pointer + i);
                if (isValidCombination(substring)) {
                    count += getNumberOfValidCombinationMemo(input, pointer + i, memo);
                }
            }
        }
        memo[pointer] = count;

        return memo[pointer];
    }

    private static boolean isValidCombination(String currentSubstring) {
        boolean isNotEmpty = currentSubstring.length() != 0;

        if (currentSubstring.charAt(0) == '0') return false;
        Integer curr = Integer.valueOf(currentSubstring);
        boolean isWithinRange = curr >= 1 && curr <= 26;
        return isNotEmpty && isWithinRange;
    }
}
