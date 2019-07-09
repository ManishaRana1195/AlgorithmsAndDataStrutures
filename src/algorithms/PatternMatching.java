package algorithms;

public class PatternMatching {

  public static void main(String[] args) {

    String pattern = "AABA";
    String inputString = "AABAACAADAABAABA";

    matchPattern(pattern, inputString);
  }

  private static void matchPattern(String pattern, String input) {
    int patternLen = pattern.length();
    int inputLen = input.length();
    for (int i = 0; i < inputLen - patternLen; ) {
      for (int j = 0; j < patternLen; ) {
        if (pattern.charAt(j) == input.charAt(i)) {
          i++;
          j++;
          if (j == patternLen) {
            System.out.println("Pattern found at " + (i - patternLen));
          }
        } else {
          i++;
          j = 0;
        }
      }
    }
  }
}
