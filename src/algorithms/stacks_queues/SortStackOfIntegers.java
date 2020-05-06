package algorithms.stacks_queues;

import java.util.Stack;

public class SortStackOfIntegers {

  public static void main(String[] args) {
    Stack<Integer> unsortedStack = new Stack<>();
    Stack<Integer> tempStack = new Stack<>();

    unsortedStack.push(10);
    unsortedStack.push(20);
    unsortedStack.push(30);
    unsortedStack.push(40);
    unsortedStack.push(15);
    unsortedStack.push(3);
    unsortedStack.push(8);
    unsortedStack.push(7);

    System.out.println(unsortedStack);
    tempStack.push(unsortedStack.pop());

    while (!unsortedStack.isEmpty()) {
      Integer x = unsortedStack.peek();
      Integer y = tempStack.peek();

      while (x <= y) {
        tempStack.push(unsortedStack.pop());
        if (unsortedStack.isEmpty()) {
          break;
        }
        x = unsortedStack.peek();
        y = tempStack.peek();
      }


      if (!unsortedStack.isEmpty()) {
        x = unsortedStack.pop();
        while (x > y && !tempStack.isEmpty()) {
          unsortedStack.push(tempStack.pop());
          if (tempStack.isEmpty()) {
            break;
          }
          y = tempStack.peek();
        }
        tempStack.push(x);
      }

    }
    System.out.println("The sorted values are:");
    System.out.println(tempStack);
  }
}
