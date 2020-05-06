package algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstringFastSlow {

    public static void main(String[] args) {
        String text = "ADOBECODEBANC";
        String pattern = "ABC";
        String resultString = "";
        int minLength = Integer.MAX_VALUE;
        int fast = 0;
        int slow = 0;
        int missing = pattern.length();

        while (slow <= fast) {
            int length;

            Map<String, Integer> map = getCountMap(pattern);
            String current = String.valueOf(text.charAt(fast));
            Integer currCount = map.get(current);

            // increment fast counter
            if (currCount == null) {
                fast++;
            } else {
                missing -= 1;
                map.put(current, currCount + 1);
            }

            // increment slow pointer
            while (missing == 0) {
                length = fast - slow + 1;
                if (minLength > length) {
                    minLength = length;
                    resultString = text.substring(slow, fast + 1);
                }

                String atSlow = String.valueOf(text.charAt(slow));
                Integer slowCount = map.get(atSlow);
                if (slowCount != null) {
                    map.put(current, slowCount - 1);
                    if (slowCount - 1 == 0) {
                        missing += 1;
                    }
                }
            }
            slow++;

        }

        System.out.println("Minimum length: " + minLength);
        System.out.println("Substring: " + resultString);
    }


    private static Map<String, Integer> getCountMap(String pattern) {
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            String curr = String.valueOf(pattern.charAt(i));
            countMap.put(curr, 0);
        }

        return countMap;
    }
}
