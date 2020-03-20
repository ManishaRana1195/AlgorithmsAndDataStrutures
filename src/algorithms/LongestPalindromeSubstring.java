package algorithms;

public class LongestPalindromeSubstring {
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1) return s;
        if (len == 2) {
            if (isPalindrome(0, 1, s)) return s;
        }
        String maxSub = isPalindromeMethod(s); // O(n^2)


        return maxSub;
    }

    private static String isPalindromeMethod(String s) {
        int max = 0;
        String maxSub = "";
        int len = s.length();

        for (int i = 0; i < len; i++) {
            for (int j = i; j <= len; j++) {
                if (isPalindrome(i, j - 1, s)) {
                    int length = j - i;
                    if (max < length) {
                        maxSub = s.substring(i, j);
                        max = length;
                    }
                }
            }
        }
        return maxSub;
    }

    private static boolean isPalindrome(int i, int j, String sub) {
        if (i >= j) return true;

        String charI = String.valueOf(sub.charAt(i));
        String charJ = String.valueOf(sub.charAt(j));
        return charI.equals(charJ) && isPalindrome(i + 1, j - 1, sub);
    }

    public static void main(String[] args) {
        String input = "ababccddddd";
        System.out.println(longestPalindrome(input));
    }
}
