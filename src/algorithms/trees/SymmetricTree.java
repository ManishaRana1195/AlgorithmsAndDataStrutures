package algorithms.trees;


import algorithms.graphs.TreeNode;

public class SymmetricTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);

    root.right = new TreeNode(2);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(3);


    boolean isSymmetric = isSymmetric(root);
    System.out.println("Is the tree symmetric: " + isSymmetric);

  }

  private static boolean isSymmetric(TreeNode root) {
    return root != null && isSymmetric(root.left, root.right);

  }

  private static boolean isSymmetric(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }

    if (p == null || q == null)
      return false;

    if (q.val == p.val) {
      return isSymmetric(p.left, q.right) && isSymmetric(q.left, p.right);
    }

    return false;
  }
}
