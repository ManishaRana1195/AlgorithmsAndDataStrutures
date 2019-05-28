package datastructures.graphs;

public class AdjacenyMatrixRepresentation {

  public static void main(String[] args) {
    GraphMatrix graph = new GraphMatrix(5);
    graph.addEdge(1, 2);
    graph.addEdge(0, 4);
    graph.addEdge(1, 4);
    graph.addEdge(3, 4);
    graph.addEdge(3, 2);
    graph.addEdge(3, 0);
    graph.addEdge(1, 4);
    graph.print();
    graph.removeEdge(3, 4);
    graph.print();
  }
}
