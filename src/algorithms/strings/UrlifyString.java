package algorithms.strings;

public class UrlifyString {
  public static void main(String[] args) {
    String input = "Mr John Smith     ";

    String[] words = input.trim().split(" ");
    StringBuilder builder = new StringBuilder();
    for (String word: words) {
      builder.append(word).append("%20");
    }

    System.out.println(" Updated sring: " + builder.toString());
  }
}
