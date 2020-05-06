package algorithms.sorting;

import algorithms.graphs.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    private static List<Integer> findTopologicalOrder(Graph root) {
        List<Integer> topSort = new LinkedList<>();
        if (root == null) return topSort;
        boolean[] isVisited = new boolean[root.getNumberOfVertices()];
        Stack<Integer> visitedNodes = new Stack<>();
        for (int vertex = 0; vertex < root.getNumberOfVertices(); vertex++) {
            if (!isVisited[vertex]) {
                //isVisited[vertex] = true;
                dfs(vertex, root, isVisited, visitedNodes);
            }
        }

        while (!visitedNodes.isEmpty()) {
            Integer topVal = visitedNodes.pop();
            System.out.print(topVal+"\t");
            // topSort.add(topVal);
        }
        return topSort;
    }

    private static void dfs(int vertex, Graph root, boolean[] isVisited, Stack<Integer> visitedNodes) {
        List<Integer> children = root.getAdjacentNodes(vertex);
        isVisited[vertex] = true;
        children.stream().filter(child -> !isVisited[child]).forEach(child -> {
            dfs(child, root, isVisited, visitedNodes);
        });
        visitedNodes.push(vertex);
    }


    public static void main(String[] args) {
        Graph graph = new Graph(11);
        graph.addDirectedEdge(7, 9);
        graph.addDirectedEdge(6, 8);
        graph.addDirectedEdge(6, 9);
        graph.addDirectedEdge(4, 7);
        graph.addDirectedEdge(4, 6);
        graph.addDirectedEdge(5, 6);
        graph.addDirectedEdge(5, 8);

        graph.addDirectedEdge(1, 4);
        graph.addDirectedEdge(2, 5);
        graph.addDirectedEdge(3, 4);
        graph.addDirectedEdge(3, 5);
        graph.addDirectedEdge(0, 1);
        graph.addDirectedEdge(0, 3);

        List<Integer> result = findTopologicalOrder(graph);
        for (Integer node : result) {
            System.out.print(node + ",\t");
        }
    }
}
