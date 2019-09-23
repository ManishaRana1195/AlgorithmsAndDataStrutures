package algorithms;

import java.util.LinkedList;

public class StackWithMax {
  private LinkedList<Integer> stack = new LinkedList<>();
  private LinkedList<Integer> maxStack = new LinkedList<>();

  private void push(Integer node) {
    // check node is null
    stack.addLast(node);
    if (maxStack.isEmpty())
      maxStack.addLast(node);

    if (node > maxStack.getLast())
      maxStack.addLast(node);
  }

  private Integer pop() {
    if (stack.size() > 0) {
      Integer topmost = stack.removeLast();
      if (maxStack.getLast().equals(topmost)) {
        maxStack.removeLast();
      }
      return topmost;
    }
    return null;
  }

  private Integer getMaxValue() {
    if (maxStack.size() > 0)
      return maxStack.getLast();

    return null;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    for (Integer val: stack) {
      result.append(" ").append(val);
    }
    return result.toString();
  }

  public static void main(String[] args) {
    StackWithMax stack = new StackWithMax();
    stack.push(10);
    stack.push(55);
    stack.push(60);
    stack.push(200);
    stack.push(180);
    stack.push(50);
    stack.push(70);
    stack.push(5);

    System.out.println("Stack => " + stack.toString());

    System.out.println("Maximum value:" + stack.getMaxValue());
    stack.pop();
    System.out.println("Maximum value:" + stack.getMaxValue());
    stack.pop();
    System.out.println("Maximum value:" + stack.getMaxValue());
    stack.pop();
    System.out.println("Maximum value:" + stack.getMaxValue());
    stack.pop();
    System.out.println("Maximum value:" + stack.getMaxValue());
    stack.pop();

  }
}
