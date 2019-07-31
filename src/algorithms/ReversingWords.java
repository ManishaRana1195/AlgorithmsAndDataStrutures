package algorithms;

public class ReversingWords {
  public static void main(String[] args) {
    String[] words = {"c", "h", "e", "c", "k", " ", "m", "a", "t", "e", " ", "b", "u", "d", "d", "y"};

    int len = words.length;
    for (int i = 0; i < len / 2; i++) {
      reverseCharacters(i, len - 1 - i, words);
    }

    int prevIndex, startIndex = 0;
    for (int i = 0; i < len; i++) {
      if (words[i].equals(" ")) {
        prevIndex = i;
        swapCharactersBetween(startIndex, prevIndex, words);
        startIndex += i;
      }
    }
    for (String word: words) {
      System.out.println(word);
    }
  }

  private static void swapCharactersBetween(int startIndex, int endIndex, String[] words) {
    while (startIndex < endIndex) {
      reverseCharacters(startIndex, endIndex, words);
      startIndex += 1;
      endIndex -= 1;
    }
  }

  private static void reverseCharacters(int i, int j, String[] words) {
    String temp = words[i];
    words[i] = words[j];
    words[j] = temp;
  }
}
