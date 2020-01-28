package datastructures.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindPairsOf2BST {

    public static void main(String[] args) {
        int sum = 16;

        Node root1 = new Node(5);
        root1.leftNode = new Node(3);
        root1.rightNode = new Node(7);
        root1.leftNode.leftNode = new Node(2);
        root1.leftNode.rightNode = new Node(4);
        root1.rightNode.leftNode = new Node(6);
        root1.rightNode.rightNode = new Node(8);

        // formation of BST 2
        Node root2 = new Node(10);
        root2.leftNode = new Node(6);
        root2.rightNode = new Node(15);
        root2.leftNode.leftNode = new Node(3);
        root2.leftNode.rightNode = new Node(8);
        root2.rightNode.leftNode = new Node(11);
        root2.rightNode.rightNode = new Node(18);

        List<int[]> result = getPairsEqualToSum(root1, root2, sum);
        for (int[] pair : result) {
            System.out.println(pair[0] + " === " + pair[1]);
        }
    }

    private static List<int[]> getPairsEqualToSum(Node root1, Node root2, int sum) {
        ArrayList<int[]> result = new ArrayList<>();
        Stack<Integer> inorderStack1 = new Stack<>();
        Stack<Integer> inorderStack2 = new Stack<>();
        inorder(root1, inorderStack1);
        reverseInorder(root2, inorderStack2);

        while (true) {

            if (inorderStack1.isEmpty()) break;
            if (inorderStack2.isEmpty()) break;

            Integer tree1Val = inorderStack1.peek();
            Integer tree2Val = inorderStack2.peek();

            if (tree1Val + tree2Val == sum) {
                result.add(new int[]{tree1Val, tree2Val});
                inorderStack1.pop();
                inorderStack2.pop();
            } else if (tree1Val + tree2Val < sum) {
                inorderStack2.pop();
            } else {
                inorderStack1.pop();
            }

        }


        return result;
    }

    private static void reverseInorder(Node node, Stack<Integer> stack) {
        if (node == null) return;

        reverseInorder(node.rightNode, stack);
        stack.push(node.value);
        reverseInorder(node.leftNode, stack);
    }

    private static void inorder(Node node, Stack<Integer> stack) {
        if (node == null) return;

        inorder(node.leftNode, stack);
        stack.push(node.value);
        inorder(node.rightNode, stack);
    }
}
