package algorithms;

public class PalindromePermutation {


  public static void main(String[] args) {
    String testString = "TactCoa";

    System.out.println("Is permutation of palindrome: "
        + checkIsPermutationOfPalindrome(testString.toLowerCase()));

    testString = "TactCooa";
    System.out.println("Is permutation of palindrome: "
        + checkIsPermutationOfPalindrome(testString.toLowerCase()));

    testString = "TactComa";
    System.out.println("Is permutation of palindrome: "
        + checkIsPermutationOfPalindrome(testString.toLowerCase()));
  }

  private static boolean checkIsPermutationOfPalindrome(String testString) {
    int[] charactersFrequency = new int[128];
    for (int i = 0 ;i < testString.length() ; i++){
      char currentChar = testString.charAt(i);
      charactersFrequency[currentChar] += 1;
    }

    int oddCount = 0;
    for (int val: charactersFrequency) {
      if(val%2 == 1){
        oddCount += 1;
      }
      if(oddCount > 1){
        return false;
      }
    }

    return true;
  }
}
