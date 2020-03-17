package datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    List<TreeNode> getChildren() {
        ArrayList<TreeNode> children = new ArrayList<>();
        if (this.left != null) {
            children.add(this.left);
        }

        if (this.right != null) {
            children.add(this.right);
        }
        return children;
    }
}
