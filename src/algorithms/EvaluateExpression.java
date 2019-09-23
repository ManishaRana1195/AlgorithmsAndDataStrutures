package algorithms;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateExpression {

  public static void main(String[] args) {
    Node node1 = new Node("*");
    node1.left = new Node("+");
    node1.left.right = new Node("4");
    node1.left.left = new Node("5");

    node1.right = new Node("+");
    node1.right.right = new Node("3");
    node1.right.left = new Node("2");

    ArrayList<String> expression = formExpression(node1);
    System.out.println("Expression is:" + expression.toString());
    System.out.println("Evaluated result: " + evaluateExpression(expression));

  }

  private static Integer evaluateExpression(ArrayList<String> expressionArray) {
    Stack<Integer> stack = new Stack<>();
    for (String current: expressionArray) {
      if (isOperator(current)) {
        Integer topmost = stack.pop();
        Integer secondTopmost = stack.pop();
        stack.push(evaluate(topmost, current, secondTopmost));
      } else {
        stack.push(Integer.valueOf(current));
      }

    }
    return stack.pop();
  }

  private static int evaluate(Integer topmost, String current, Integer secondTopmost) {
    switch (current) {
      case "*":
        return topmost * secondTopmost;
      case "/":
        return topmost / secondTopmost;
      case "+":
        return topmost + secondTopmost;
      case "-":
        return topmost - secondTopmost;
      default:
        return 0;
    }
  }

  private static boolean isOperator(String current) {
    switch (current) {
      case "*":
      case "/":
      case "+":
      case "-":
        return true;
      default:
        return false;

    }
  }

  private static ArrayList<String> formExpression(Node node1) {
    ArrayList<String> expression = new ArrayList<>();
    postTraversal(node1, expression);
    return expression;
  }

  private static void postTraversal(Node node1, ArrayList<String> expression) {
    if (node1 == null)
      return;

    postTraversal(node1.left, expression);
    postTraversal(node1.right, expression);
    expression.add(node1.value);
  }


}
