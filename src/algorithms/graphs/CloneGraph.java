package algorithms.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

    public static void main(String[] args) {
        Node node = null;

        boolean[] isVisited = new boolean[101];
        HashMap<Node, Node> map = new HashMap<>();
        
        dfs(node, isVisited, map);
    }

    private static Node dfs(Node topNode, boolean[] isVisited, HashMap<Node, Node> map) {
        Node topNodeDash = null;

        if (!isVisited[topNode.value - 1]) {

            topNodeDash = getReference(map, topNode);
            ArrayList<Node> neighboursDash = new ArrayList<>();
            isVisited[topNode.value - 1] = true;

            for (Node neighbor : topNode.neighbors) {
                Node currentReference = getReference(map, neighbor);
                neighboursDash.add(currentReference);
                dfs(neighbor, isVisited, map);
            }
            topNodeDash.neighbors = neighboursDash;
            for (Node n : topNodeDash.neighbors) {
                System.out.println(n.value);
            }
        }
        return topNodeDash;
    }


    private static Node getReference(HashMap<Node, Node> map, Node currentNode) {
        Node currentReference = map.getOrDefault(currentNode, null);
        if (currentReference == null) {
            currentReference = new Node(currentNode.value);
            map.put(currentNode, currentReference);
        }
        return currentReference;
    }
}

class Node {
    public int value;
    public List<Node> neighbors;

    public Node(int value) {
        this.value = value;
        this.neighbors = new ArrayList<>();
    }
}


