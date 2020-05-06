package algorithms.graphs;

public class AdjacencyListRepresentation {

  public static void main(String[] args) {
    Graph graph = new Graph(7);
    graph.addDirectedEdge(1, 2);
    graph.addDirectedEdge(0, 5);
    graph.addDirectedEdge(3, 2);
    graph.addDirectedEdge(4, 3);
    graph.addDirectedEdge(5, 3);
    graph.addDirectedEdge(6, 5);
    graph.addDirectedEdge(4, 1);
    graph.print();
    graph.removeEdge(1, 2);
    graph.print();
    graph.removeEdge(3, 4);
    graph.print();
  }
}
