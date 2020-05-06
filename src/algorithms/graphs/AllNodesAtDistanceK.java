package algorithms.graphs;

import java.util.*;

public class AllNodesAtDistanceK {

    public static void main(String[] args) {

        TreeNode root = null;
        TreeNode start = null;
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        getParentMap(null, root, parentMap);
        List<Integer> result = new ArrayList<>();

        int k = 2;
        int currLevel = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(start);
        Set<TreeNode> isVisitedSet = new HashSet<>();
        while (!queue.isEmpty()) {
            int itemsInLayer = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (itemsInLayer > 0) {
                TreeNode top = queue.poll();
                if (!isVisitedSet.contains(top)) {
                    isVisitedSet.add(top);
                    List<TreeNode> neigbhors = getNeighbors(top, parentMap);
                    for (TreeNode neighbor : neigbhors) {
                        if (!isVisitedSet.contains(neighbor)) {
                            queue.add(neighbor);
                        }
                    }
                }
                temp.add(top.val);
                itemsInLayer -= 1;
                if (itemsInLayer == 0) {
                    currLevel += 1;
                }
            }
            if (k == currLevel) {
                result = temp;
                break;
            }

        }


    }

    private static List<TreeNode> getNeighbors(TreeNode top, HashMap<TreeNode, TreeNode> parentMap) {
        ArrayList<TreeNode> neighbors = new ArrayList<>();
        if (top.left != null)
            neighbors.add(top.left);
        if (top.right != null)
            neighbors.add(top.right);
        TreeNode parent = parentMap.getOrDefault(top, null);
        if (parent != null) {
            neighbors.add(parent);
        }
        return neighbors;
    }

    private static void getParentMap(TreeNode parent, TreeNode root, HashMap<TreeNode, TreeNode> parentMap) {
        if (root == null) return;

        getParentMap(root, root.left, parentMap);
        parentMap.put(root, parent);
        getParentMap(root, root.right, parentMap);
    }
}
