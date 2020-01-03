package algorithms.Recursion;

import java.util.ArrayList;

public class PathSumInBst {

    public static void main(String[] args) {
        BSTNode node1 = new BSTNode(null, null, 70);
        BSTNode node2 = new BSTNode(null, null, 40);
        BSTNode node3 = new BSTNode(null, null, 20);
        BSTNode node4 = new BSTNode(null, null, 5);
        BSTNode node5 = new BSTNode(node2, node1, 60);
        BSTNode node6 = new BSTNode(node4, node3, 10);
        BSTNode root = new BSTNode(node6, node5, 30);

        int sum = 90;
        ArrayList<BSTNode> path = new ArrayList<>();
        getBSTPath(path, sum, root, 0);
        if (path.isEmpty()) {
            System.out.println("No such path exists");
        } else {
            System.out.println("The path that has the sum");
            for (BSTNode node : path) {
                System.out.print(node.value + " ==> ");
            }
        }
    }

    private static void getBSTPath(ArrayList<BSTNode> path, int sum, BSTNode root, int currentSum) {
        if (root == null) return;
        if (currentSum + root.value > sum)
            return;

        if (currentSum + root.value <= sum) {
            currentSum += root.value;
            path.add(root);
        }

        if (root.right == null || currentSum + root.right.value > sum) {
            getBSTPath(path, sum, root.left, currentSum);
        } else {
            getBSTPath(path, sum, root.right, currentSum);
        }
    }
}

class BSTNode {
    BSTNode left;
    BSTNode right;
    int value;

    BSTNode(BSTNode left, BSTNode right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
}
