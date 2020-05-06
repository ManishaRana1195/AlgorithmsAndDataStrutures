package algorithms.strings;

/*Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures?

To avoid the additional data structure, we can sort the string with NlogN complexity and compare
the consecutive characters */


public class UniqueCharacters {
  public static void main(String[] args) {
    String inputString = "Implementanalgorithmtodetermine";

    System.out.println(hasUniqueCharacters(inputString));
    System.out.println(hasUniqueCharacters("algorithm"));
  }

  private static boolean hasUniqueCharacters(String inputString) {
    if (inputString.length() > 128)
      return false; /*The string may contain lower, upper, special characters,so total 128*/

    boolean[] isContainedInString = new boolean[128];
    for (int i = 0; i < inputString.length(); i++) {
      char currentChar = inputString.charAt(i);
      if (isContainedInString[currentChar]) {
        return false;
      }
      isContainedInString[currentChar] = true;
    }

    return true;
  }
}
