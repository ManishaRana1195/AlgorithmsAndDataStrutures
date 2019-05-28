package datastructures.graphs;

class GraphMatrix {
  private int[][] graph;

  GraphMatrix(int vertices) {
    graph = new int[vertices][vertices];
  }

  void addEdge(int vertex1, int vertex2) {
    graph[vertex1][vertex2] = 1;
  }

  void print() {
    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph.length; j++) {
        if (graph[i][j] == 1) {
          System.out.println("vertex " + i + " connected to vertex " + j);
        }
      }
    }

    System.out.println("*******************************");
  }

  void removeEdge(int vertex1, int vertex2) {
    graph[vertex1][vertex2] = 0;
  }
}
