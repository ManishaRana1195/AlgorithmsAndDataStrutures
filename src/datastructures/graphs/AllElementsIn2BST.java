package datastructures.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllElementsIn2BST {

    public static void main(String[] args) {
        TreeNode root1 = null;
        TreeNode root2 = null;

        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        while (root1 != null || root2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
            while (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }

            while (root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            }

            if (stack2.isEmpty() || (!stack1.isEmpty() && stack1.peek().val <= stack2.peek().val)) {
                TreeNode top = stack1.pop();
                result.add(top.val);
                root1 = top.right;
            } else {
                TreeNode top = stack2.pop();
                result.add(top.val);
                root2 = top.right;
            }
        }
        // print result
    }
}
