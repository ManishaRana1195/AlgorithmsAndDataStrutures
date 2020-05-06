package algorithms.graphs;

import java.util.*;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode seven = new TreeNode(7);
        TreeNode six = new TreeNode(6);
        TreeNode three = new TreeNode(3);
        three.left = six;
        three.right = seven;

        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        four.left = new TreeNode(8);
        two.left = four;
        two.right = five;

        TreeNode one = new TreeNode(1);
        one.left = two;
        one.right = three;

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(one);
        while (!queue.isEmpty()) {
            int itemsInLayer = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (itemsInLayer > 0) {
                TreeNode front = queue.poll();
                List<TreeNode> children = front.getChildren();
                queue.addAll(children);
                itemsInLayer -= 1;
                temp.add(front.val);
            }
            result.add(temp);
        }

        for (List<Integer> temp : result) {
            for (Integer node : temp) {
                System.out.print(node + "\t");
            }
            System.out.println();
        }

    }
}

