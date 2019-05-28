package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaximumStreak {

  public static void main(String[] args) {
    List<String> data = new ArrayList<>();
    data.add("NYY");

    System.out.println(maxStreak(3, data));
  }

  private static int maxStreak(int m, List<String> data) {
    boolean[] schedules;
    boolean[] andResult = new boolean[data.size()];
    for (int i = 0; i < andResult.length; i++) {
      andResult[i] = true;
    }

    for (int i = 0; i < data.size(); i++) {
      schedules = convertToBinary(data.get(i));

      for (boolean schedule: schedules) {
        andResult[i] = (andResult[i] & schedule);
      }
    }

    int maxCount = 0, maximum = 0;
    Stack<Integer> result = new Stack<>();
    for (int i = 0; i < andResult.length - 1; i++) {
      if (andResult[i]) {
        result.push(1);
      } else {
        while (!result.isEmpty()) {
          result.pop();
          maxCount += 1;
        }
        if (maxCount > maximum) {
          maximum = maxCount;
        }
        maxCount = 0;
      }
    }

    return maximum;
  }

  private static boolean[] convertToBinary(String s) {
    boolean[] result = new boolean[s.length()];
    for (int i = 0; i < s.length(); i++) {
      result[i] = s.charAt(i) == 'Y';
    }
    return result;
  }
}
