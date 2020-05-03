package datastructures.stacks_queues;

import java.util.Stack;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        String s = "a##c";
        String t = "#a#c";


        boolean isEqual = backspaceCompare(s, t);
        System.out.println("Are backspaced strings equal: " + isEqual);
    }

    public static boolean backspaceCompare(String S, String T) {
        return getBackspacedStringSB(S).equals(getBackspacedStringSB(T));
    }

    private static String getBackspacedString(String input) {
        java.util.Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < input.length()) {
            String curr = String.valueOf(input.charAt(i));
            i++;
            if (curr.equals("#")) {
                if (stack.isEmpty()) continue;
                stack.pop();
            } else {
                stack.push(curr);
            }
        }


        if (stack.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();

        for (String element : stack) {
            sb.append(element);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    private static String getBackspacedStringSB(String input) {
        int i = 0;
        StringBuilder stack = new StringBuilder();
        while (i < input.length()) {
            String curr = String.valueOf(input.charAt(i));
            i++;
            if (curr.equals("#")) {
                if (stack.length() == 0) continue;
                int len = stack.length();
                stack.deleteCharAt(len - 1);
            } else {
                stack.append(curr);
            }
        }

        System.out.println(stack.toString());
        return stack.toString();
    }
}
