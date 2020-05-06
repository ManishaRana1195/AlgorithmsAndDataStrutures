package algorithms.Recursion;

import java.util.HashMap;
import java.util.Map;

public class NSteps {

  public static void main(String[] args) {
    int nSteps = 36;
    Map<Integer, Integer> result = new HashMap<>();
    // Adding the base cases
    result.put(1, 1);
    result.put(2, 2);
    result.put(3, 4);
    noOfPermutations(nSteps, result);
    System.out.println("Number Of ways in which bob can cover "
        + nSteps + " Steps are:" + result.get(nSteps));
  }

  private static int noOfPermutations(int nSteps, Map<Integer, Integer> result) {
    if (nSteps == 1) {
      return 1;
    }

    if (result.containsKey(nSteps)) {
      return result.get(nSteps);
    }

    int nMinusOneVal = noOfPermutations(nSteps - 1, result);
    int nMinusTwoVal = noOfPermutations(nSteps - 2, result);
    int nMinusThreeVal = noOfPermutations(nSteps - 3, result);
    result.put(nSteps, nMinusOneVal + nMinusTwoVal + nMinusThreeVal);
    return result.get(nSteps);
  }
}
