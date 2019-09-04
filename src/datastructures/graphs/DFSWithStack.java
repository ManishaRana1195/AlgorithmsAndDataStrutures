package datastructures.graphs;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFSWithStack {

  public static void main(String[] args) {
    Graph graph = new Graph(9);
    graph.addDirectedEdge(1, 2);
    graph.addDirectedEdge(1, 3);
    graph.addDirectedEdge(2, 5);
    graph.addDirectedEdge(2, 4);
    graph.addDirectedEdge(3, 6);
    graph.addDirectedEdge(6, 7);
    graph.addDirectedEdge(6, 8);

    int numberOfNodes = 9;
    boolean[] isVisited = new boolean[numberOfNodes];

    List<Integer> result = getDFSOrder(graph, isVisited);
    for (Integer node: result) {
      System.out.print(node + " ==> ");
    }
  }

  private static List<Integer> getDFSOrder(Graph graph, boolean[] isVisited) {
    List<Integer> result = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();   // explicitly storing in heap memory
    int root = 1;
    stack.push(root);

    while (!stack.isEmpty()) {
      Integer current = stack.pop();
      if (!isVisited[current]) {
        isVisited[current] = true;
        List<Integer> adjacentNodes = graph.getAdjacentNodes(current);
        adjacentNodes.forEach(stack::push);
        result.add(current);
      }
    }

    return result;
  }
}
