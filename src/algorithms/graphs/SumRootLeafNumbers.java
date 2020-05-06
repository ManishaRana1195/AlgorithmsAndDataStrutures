package algorithms.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SumRootLeafNumbers {

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        TreeNode root = null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        dfs(result, "", stack);
        int sum = 0;
        for (String temp : result) {
            sum = Integer.valueOf(temp);
        }

        System.out.println(sum);
    }

    private static void dfs(List<String> result, String currSum, Stack<TreeNode> stack) {

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            List<TreeNode> children = top.getChildren();
            if (children.isEmpty()) {
                result.add(currSum + top.val);
                continue;
            }
            for (TreeNode child : children) {
                stack.push(child);
                dfs(result, currSum + top.val, stack);
            }

        }
    }
}
