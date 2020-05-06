package algorithms.strings;

public class PatternMatching {

  public static void main(String[] args) {

    String pattern = "AABA";
    String inputString = "AABAACAADAABAABA";

    matchPattern(pattern, inputString);
    System.out.println("*******************");
    matchOverlappingPattern(pattern, inputString);
  }

  private static void matchOverlappingPattern(String pattern, String input) {
    int patternLen = pattern.length();
    int inputLen = input.length();
    for (int i = 0; i <= inputLen - patternLen; i++) {
      int j;
      for (j = 0; j < patternLen; j++) {
        if (pattern.charAt(j) != input.charAt(i+j)) {
          break;
        }
      }
      if (j == patternLen) {
        System.out.println("Pattern found at " + (i));
      }
    }
  }

  private static void matchPattern(String pattern, String input) {
    int patternLen = pattern.length();
    int inputLen = input.length();
    for (int i = 0; i <= inputLen - patternLen; i++) {
      for (int j = 0; j < patternLen; ) {
        if (pattern.charAt(j) != input.charAt(i)) {
          break;
        }

        if (pattern.charAt(j) == input.charAt(i)) {
          i++;
          j++;
          if (j == patternLen) {
            System.out.println("Pattern found at " + (i - patternLen));
          }
        }
      }
    }


  }
}
