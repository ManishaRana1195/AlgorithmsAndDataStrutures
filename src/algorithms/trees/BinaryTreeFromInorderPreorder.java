package algorithms.trees;

import algorithms.graphs.TreeNode;

import java.util.HashMap;

public class BinaryTreeFromInorderPreorder {

    public static void main(String[] args) {
        int[] inorder = {};
        int[] preorder = {};

        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }


        TreeNode root = getBinaryTree(inorder, preorder, inorderMap, 0, preorder.length - 1, 0, inorder.length - 1);
        // print tree
    }

    private static TreeNode getBinaryTree(int[] inorder, int[] preorder, HashMap<Integer, Integer> inorderMap,
                                          int preorderStart, int preorderEnd,
                                          int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) return null;


        TreeNode root = new TreeNode(preorder[preorderStart]);
        int rootIndex = inorderMap.get(root.val);
        int preorderLeftStart = preorderStart + 1;
        int inorderLeftStart = inorderStart;
        int inorderLeftEnd = rootIndex - 1;
        int preorderLeftEnd = preorderLeftStart + (inorderLeftEnd - inorderLeftStart);

        int preorderRightStart = preorderLeftStart + 1;
        int preorderRightEnd = preorderEnd;
        int inorderRightStart = rootIndex + 1;
        int inorderRightEnd = inorderEnd;

        root.left = getBinaryTree(inorder, preorder, inorderMap, preorderLeftStart,
                preorderLeftEnd, inorderLeftStart, inorderLeftEnd);
        root.right = getBinaryTree(inorder, preorder, inorderMap, preorderRightStart,
                preorderRightEnd, inorderRightStart, inorderRightEnd);

        return root;
    }

}
