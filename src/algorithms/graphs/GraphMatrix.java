package algorithms.graphs;

class GraphMatrix {
  private int[][] graph;
  private int numberOfVertices;

  GraphMatrix(int vertices) {
    graph = new int[vertices][vertices];
    numberOfVertices = vertices;
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

  void addExit(int vertex1, int vertex2) {
    graph[vertex1][vertex2] = 2; // 2 represents exit
  }

  int getNumberOfVertices() {
    return this.numberOfVertices;
  }

  public int get(int x, int y) {
    return graph[x][y];
  }
}
