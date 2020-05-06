package algorithms.strings;

public class SearchStringTinP {

    /*This implementation uses Rabin Karp*/
    public static void main(String[] args) {
        String pattern = "orl";
        String text = "Hello World in Java";

        searchPatternInText(pattern, text);

        //pattern = "xyz";
        //searchPatternInText(pattern, text);
    }

    private static void searchPatternInText(String pattern, String text) {
        long patternHash = getStringHash(pattern);
        int pLen = pattern.length();
        long tempHash = getStringHash(text.substring(0, pLen));
        System.out.println(patternHash);
        if (tempHash == patternHash) {
            System.out.println("Text \'" + text + "\' contains pattern " + pattern + " at index " + 0);
            return;
        }

        for (int i = pLen; i < text.length(); i++) {
            int start = i - pLen;
            int end = i;
            tempHash = getTextSegmentHash(start, end, tempHash, text);

            if (tempHash == patternHash) {
                String substring = text.substring(start + 1, end + 1);
                if (substring.equals(pattern)) {
                    System.out.println("Text \'" + text + "\' contains pattern " + pattern + " at index " + start);
                }
            }
        }

        System.out.println("Text " + text + " doesn't contains pattern " + pattern);
    }

    private static long getTextSegmentHash(int start, int end, long tempHash, String text) {
        int x = 31;
        int firstChar = text.charAt(start);
        int lastChar = text.charAt(end);
        int power = end - start - 1;

        double firstCharPowerValue = firstChar * Math.pow(x, power);
        tempHash = (long) ((tempHash - firstCharPowerValue) * x + lastChar);
        return tempHash;
    }

    private static long getStringHash(String pattern) {
        int x = 31;
        long hashValue = 0;
        int len = pattern.length();
        for (int i = 0; i < len; i++) {
            Integer currentChar = (int) pattern.charAt(i);
            hashValue += currentChar * Math.pow(x, len - i - 1);
        }
        return hashValue;
    }
}
