package datastructures.graphs;

public class AdjacencyListRepresentation {

  public static void main(String[] args) {
    Graph graph = new Graph(7);
    graph.addEdge(1, 2);
    graph.addEdge(0, 5);
    graph.addEdge(3, 2);
    graph.addEdge(4, 3);
    graph.addEdge(5, 3);
    graph.addEdge(6, 5);
    graph.addEdge(4, 1);
    graph.print();
    graph.removeEdge(1, 2);
    graph.print();
    graph.removeEdge(3, 4);
    graph.print();
  }
}
