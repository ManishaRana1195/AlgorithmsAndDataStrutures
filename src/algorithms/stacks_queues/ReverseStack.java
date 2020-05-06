package algorithms.stacks_queues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);

        List<Integer> result = new ArrayList<>();
        reverseStack(stack, result);
        for (Integer element : result) {
            System.out.println(element);
        }
    }

    private static void reverseStack(Stack<Integer> stack, List<Integer> result) {
        if (stack.size() == 0) return;

        Integer top = stack.pop();
        reverseStack(stack, result);
        result.add(top);
    }
}
