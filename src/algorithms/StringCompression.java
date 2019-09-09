package algorithms;

public class StringCompression {

  public static void main(String[] args) {
    String actual = "aaaaabbbbbbbbbbvvvvrfffff";
    System.out.println("The compressed string is: " + getCompressedString(actual));
  }

  private static String getCompressedString(String actual) {
    StringBuilder result = new StringBuilder();
    int currentCount = 0;

    for (int i = 0; i < actual.length(); i++) {
      currentCount += 1;
      if (i + 1 >= actual.length() || actual.charAt(i) != actual.charAt(i + 1)) {
        result.append(actual.charAt(i));
        result.append(currentCount);
        currentCount = 0;
      }

    }

    return result.toString();
  }
}
