package algorithms.graphs;


import java.util.LinkedList;
import java.util.List;

public class BFS {

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
    bfs(graph, numberOfVertices);
  }

  private static void bfs(Graph graph, int numberOfVertices) {
    boolean[] isVisited = new boolean[numberOfVertices];
    LinkedList<Integer> exploredVertices = new LinkedList<>();

    int startVertex = 1;
    exploredVertices.push(startVertex);
    while (!exploredVertices.isEmpty()) {
      Integer node = exploredVertices.pop();
      if (!isVisited[node]) {
        isVisited[node] = true;
        List<Integer> nextNode = graph.getAdjacentNodes(node);
        exploredVertices.addAll(nextNode);
        System.out.print(" ====> " + node);
      }
    }
  }
}
