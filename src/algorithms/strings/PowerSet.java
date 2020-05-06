package algorithms.strings;

import java.util.HashSet;
import java.util.Set;

public class PowerSet {


  public static void main(String[] args) {
    String inputString = "efgh";
    Set<String> powerset = new HashSet<>();
    generatePowerSet(inputString, "", 0, powerset);
    for (String key: powerset) {
      System.out.println(key);
    }
  }

  private static void generatePowerSet(String inputString, String prefix, int index, Set<String> powerset) {
    if (inputString.length() == index) {
      powerset.add(prefix);
      return;
    }

    generatePowerSet(inputString,
        prefix + inputString.charAt(index),
        index + 1, powerset);
    generatePowerSet(inputString,
        prefix , index+1, powerset);

  }
}
