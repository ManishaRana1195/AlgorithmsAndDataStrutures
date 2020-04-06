package datastructures.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class IsBipartiteGraph {

    /*should be implemented as bfs, as you need to queue the children of the node,
    * also the graph could be weakly connected, so need bfs on each vertex*/
    public static void main(String[] args) {
        // int[][] graph = {{1}, {0, 3}, {3}, {1, 2}};

        int[][] graph = {{}, {2, 4, 6}, {1, 4, 8, 9}, {7, 8}, {1, 2, 8, 9}, {6, 9},
                {1, 5, 7, 8, 9}, {3, 6, 9}, {2, 3, 4, 6, 9}, {2, 4, 5, 6, 7, 8}};
        System.out.println("is the graph bipartite:");
        for (int vertex = 0; vertex < graph.length; vertex++) {
            HashMap<Integer, Integer> colorMap = new HashMap<>();

            if (getColor(colorMap, vertex) == -1) {
                if (!isBipartiteGraph(graph, colorMap, vertex)) {
                    System.out.println("false");
                    break;
                }
            }
        }

        //isBipartite = isBipartiteGraph(graph2);
        //System.out.println("is the graph bipartite:" + isBipartite);
    }

    private static boolean isBipartiteGraph(int[][] graph, HashMap<Integer, Integer> colorMap, int vertex) {
        int currentColor = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        colorMap.put(vertex, currentColor);

        while (!queue.isEmpty()) {
            Integer first = queue.remove();
            currentColor = getColor(colorMap, first);
            for (int neighbor : graph[first]) {
                int neighborColor = getColor(colorMap, neighbor);
                if (neighborColor == currentColor)
                    return false;

                if (neighborColor == -1 && currentColor != neighborColor) {
                    colorMap.put(neighbor, 1 - currentColor);
                    queue.add(neighbor);
                }
            }
        }

        return true;
    }

    private static int getColor(HashMap<Integer, Integer> colorMap, int vertex) {
        return colorMap.getOrDefault(vertex, -1);
    }

}
