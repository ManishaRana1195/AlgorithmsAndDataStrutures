package algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class PermutationOfString {

  public static void main(String[] args) {
    String searchString = "acd";
    String inputString = "aabcd";


    //System.out.println(isPermutationOf(inputString, searchString));
    //System.out.println(isPermutationOf(inputString, "wxad"));
    //System.out.println(isPermutationOf(inputString, "abbcd"));

    System.out.println(checkPermutation(inputString, searchString));
    System.out.println(checkPermutation(inputString, "wxad"));
    System.out.println(checkPermutation(inputString, "abbcd"));
  }

  private static boolean isPermutationOf(String inputString, String searchString) {
    Map<String, Integer> permutationMap = new HashMap<>();
    getPermutations("", inputString, permutationMap);

    return permutationMap.containsKey(searchString);
  }

  /*Complexity O(N!)*/
  private static void getPermutations(String prefix, String inputString, Map<String, Integer> permutationMap) {
    int len = inputString.length();
    if (len == 0)
      permutationMap.put(prefix, 1);

    for (int i = 0; i < len; i++) {
      getPermutations(prefix + inputString.charAt(i),
          inputString.substring(0, i) + inputString.substring(i + 1),
          permutationMap);
    }

  }

  /*Complexity O(N)*/
  private static boolean checkPermutation(String inputString, String searchString) {
    int[] inputStringCharacterCount = new int[128];
    for (int i = 0; i < inputString.length(); i++) {
      char currentChar = inputString.charAt(i);
      inputStringCharacterCount[currentChar] += 1;
    }

    for (int i = 0; i < searchString.length(); i++) {
      char currentChar = searchString.charAt(i);
      inputStringCharacterCount[currentChar] -= 1;
      if(inputStringCharacterCount[currentChar] < 0){
        return false;
      }
    }

    return true;
  }
}
