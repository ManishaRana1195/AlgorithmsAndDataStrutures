package algorithms.Recursion;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class WordBreakProblem {

    public static void main(String[] args) {
        String input = "ilikemangotango";
        Set<String> set = getWordDictionary();

        Stack<String> result = new Stack<>();
        Boolean memo[] = new Boolean[input.length()];
        int startIndex = 0;
        getValidSubstrings(input, startIndex, result, memo, set);

        String resultString = "";
        for (String temp : result) {
            resultString += temp + " ";
        }
        System.out.println("One of the valid string is:" + resultString);
    }

    private static boolean getValidSubstrings(String input, int startIndex, Stack<String> result, Boolean[] memo, Set<String> set) {
        int len = input.length();
        if (startIndex == len) return true;
        if (memo[startIndex] != null && !memo[startIndex]) return false;

        for (int i = startIndex; i < len; i++) {
            String substring = input.substring(startIndex, i + 1);
            if (set.contains(substring)) {
                result.push(substring);
                if (getValidSubstrings(input, i + 1, result, memo, set)) {
                    return true;
                } else {
                    result.pop();
                    memo[i + 1] = false;
                }
            }
        }
        return false;
    }

    private static Set<String> getWordDictionary() {
        Set<String> set = new HashSet<>();
        set.add("i");
        set.add("like");
        set.add("mango");
        set.add("tango");
        set.add("man");
        set.add("tan");
        set.add("go");
        return set;
    }
}
