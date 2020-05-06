package algorithms.strings;

public class StringMatching {

    public static void main(String[] args) {
        String text = "public void main";
        String pattern = "void";
        int index = getMatchIndex(text, pattern);
        System.out.println("The index where the pattern matches the text: ");
        System.out.println(index);
    }

    /*Brute force way of string matching*/
    private static int getMatchIndex(String text, String pattern) {
        for (int i = 0; i < text.length(); i++) {
            int j = 0;
            for (; j < pattern.length(); j++) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    break;
                }
            }

            if (j == pattern.length()) {
                return i;
            }
        }
        return -1;
    }
}
