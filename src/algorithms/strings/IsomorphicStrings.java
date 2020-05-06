package algorithms.strings;

import java.util.HashMap;

public class IsomorphicStrings {
  /*One string is isomorphic of another, if characters
  in one string could be replace to the resultant string*/
  public static void main(String[] args) {
    System.out.println(isIsomorphicStrings("abcd", "efgh"));
    System.out.println(isIsomorphicStrings("egg", "abb"));
    System.out.println(isIsomorphicStrings("eggg", "abbc"));
  }

  private static boolean isIsomorphicStrings(String stringA, String stringB) {
    HashMap<String, String> characterPairs = new HashMap<>();
    if (stringA.length() != stringB.length())
      return false;

    for (int i = 0; i < stringA.length(); i++) {
      String a = String.valueOf(stringA.charAt(i));
      String b = String.valueOf(stringB.charAt(i));

      if (characterPairs.containsKey(a)) {
        if (!characterPairs.get(a).equals(b)) {
          return false;
        }
      } else {
        if (characterPairs.containsKey(b)) {
          return false;
        }

        characterPairs.put(a, b);         /*Take care of mappings in both ways*/
        characterPairs.put(b, a);
      }

    }
    return true;
  }
}
