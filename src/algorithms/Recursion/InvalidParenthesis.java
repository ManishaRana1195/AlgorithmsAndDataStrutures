package algorithms.Recursion;

import java.util.Stack;

public class InvalidParenthesis {
    public static void main(String[] args) {
        String string = "[]{}()[]";
        System.out.println("Is the pattern " + string + " valid: " + isValid(string));
    }

    private static boolean isValid(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return true;
        }
        if (s.length() == 1) {
            return false;
        }
        Stack<String> parents = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String curr = String.valueOf(s.charAt(i));
            if (curr.equals("{") || curr.equals("[") || curr.equals("(")) {
                parents.push(curr);
            }

            if (isMatchingParenthesis(parents, curr, "}", "{")) return false;
            if (isMatchingParenthesis(parents, curr, "]", "[")) return false;
            if (isMatchingParenthesis(parents, curr, ")", "(")) return false;
        }

        return parents.size() <= 0;
    }

    private static boolean isMatchingParenthesis(Stack<String> parents, String curr, String closing, String opening) {
        if (curr.equals(closing)) {
            if (parents.isEmpty()) return true;
            String top = parents.peek();
            if (top.equals(opening)) {
                parents.pop();
            } else {
                return true;
            }
        }

        return false;
    }
}