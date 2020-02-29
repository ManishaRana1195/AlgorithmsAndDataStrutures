package datastructures.strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {


    public static void main(String[] args) {
        String text = "ADOBECODEBANC";
        String pattern = "ABCAC";   // cannot handle duplicates in the pattern
        int minLength = Integer.MAX_VALUE;
        String minSubstring = "";


        for (int i = 0; i < text.length(); i++) {
            int length = Integer.MAX_VALUE;
            for (int j = i; j < text.length(); j++) {
                String current = text.substring(i, j + 1);
                if (contains(current, pattern)) {
                    length = j - i + 1;
                }
                if (minLength > length) {
                    minLength = length;
                    minSubstring = current;
                }
            }
        }

        System.out.println("min length: " + minLength);
        System.out.println("Substring: " + minSubstring);
    }

    private static boolean contains(String substring, String pattern) {
        Map<String, Integer> countMap = getCountMap(pattern);
        int count = pattern.length();

        for (int i = 0; i < substring.length(); i++) {
            String curr = String.valueOf(substring.charAt(i));
            Integer currCount = countMap.getOrDefault(curr, null);
            if (currCount != null) {
                countMap.put(curr, count - 1);
                count -= 1;
            }
        }

        return count == 0;
    }

    private static Map<String, Integer> getCountMap(String pattern) {
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            String curr = String.valueOf(pattern.charAt(i));
            Integer count = countMap.getOrDefault(curr, 0);
            countMap.put(curr, count + 1);
        }

        return countMap;
    }

}
