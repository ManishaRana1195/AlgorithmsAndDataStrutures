package algorithms.DynamicProgramming;

public class LongestPalindromeSubstringDP {
    public static String longestPalindrome(String s) {
        int len = s.length();
        Boolean[][] table = new Boolean[len][len];

        int max = 0;
        String maxSub = "";
        if (len == 1) return s;

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    table[i][j] = true;
                }
                if (i < j) {
                    table[i][j] = false;
                }

            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = i; j <= len; j++) {
                if (isPalindrome(i, j - 1, s, table)) {
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

    private static boolean isPalindrome(int i, int j, String sub, Boolean[][] table) {
        if (i > j) return true;
        if (i == j) {
            table[i][j] = true;
            return true;
        }

        String charI = String.valueOf(sub.charAt(i));
        String charJ = String.valueOf(sub.charAt(j));

        if (table[i][j] != null) return table[i][j];
        table[i][j] = charI.equals(charJ) && isPalindrome(i + 1, j - 1, sub, table);
        return table[i][j];
    }

    public static void main(String[] args) {
        String input = "cc";
        System.out.println(longestPalindrome(input));
    }
}
