package algorithms.graphs;

import java.util.List;
import java.util.Stack;

public class DFS {

  public static void main(String[] args) {
    int numberOfVertices = 6;
    Graph graph = new Graph(numberOfVertices);
    graph.addUndirectedEdge(1, 2);
    graph.addUndirectedEdge(0, 1);
    graph.addUndirectedEdge(0, 2);
    graph.addUndirectedEdge(0, 3);
    graph.addUndirectedEdge(3, 4);
    graph.addUndirectedEdge(3, 5);
    graph.addUndirectedEdge(2, 5);
    dfs(graph, numberOfVertices);
  }

  private static void dfs(Graph graph, int numberOfVertices) {
    boolean[] isVisited = new boolean[numberOfVertices];
    Stack<Integer> visitedNodes = new Stack<>();

    int startingVertex = 0;
    visitedNodes.push(startingVertex);
    dfsForVertex(graph, isVisited, visitedNodes);
  }

  private static void dfsForVertex(Graph graph, boolean[] isVisited, Stack<Integer> visitedNodes) {
    while (!visitedNodes.isEmpty()) {
      Integer current = visitedNodes.pop();
      if (!isVisited[current]) {
        System.out.print( current + " ====> ");
        isVisited[current] = true;
        List<Integer> adjacentNodes = graph.getAdjacentNodes(current);
        for (Integer node: adjacentNodes) {
          visitedNodes.push(node);
          dfsForVertex(graph, isVisited, visitedNodes);
        }
      }
    }
  }

}
