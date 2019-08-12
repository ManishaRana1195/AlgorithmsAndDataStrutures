package algorithms;

import java.util.LinkedList;
import java.util.List;

public class LinkedListIntersection {

  public static void main(String[] args) {
    String a = "pale";
    String b = "spale";

    System.out.println("Are the strings, " + a + " and " + b + " one edit away: " + isOneEditAway(a, b));
    a = "pale";
    b = "pabe";
    System.out.println("Are the strings, " + a + " and " + b + " one edit away: " + isOneEditAway(a, b));
  }

  private static boolean isOneEditAway(String a, String b) {
    List<String> stringA = new LinkedList<>(List.of(a.split("")));
    List<String> stringB = new LinkedList<>(List.of(b.split("")));

    int sizeStringB = stringB.size();
    int sizeStringA = stringA.size();

    if (Math.abs(sizeStringA - sizeStringB) > 1) {
      return false;
    }

    int i = 0, j = 0, count = 0;
    while (i != sizeStringA || j != sizeStringB) {
      if (stringA.get(i).equals(stringB.get(j))) {
        i++;
        j++;
      } else {
        count += 1;
        if (sizeStringA > sizeStringB) {
          i++;
        } else {
          j++;
        }
      }
    }

    return count <= 1;
  }
}
