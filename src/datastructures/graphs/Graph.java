package datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Graph {
  private List<ArrayList<Integer>> vertices;

  Graph(int numberOfVertices) {
    vertices = new LinkedList<>();
    for (int i = 0; i < numberOfVertices; i++) {
      vertices.add(i, new ArrayList<>());
    }
  }

  void addEdge(int vertex1, int vertex2) {
    vertices.get(vertex1).add(vertex2);
  }

  void print() {
    int i = 0;
    for (ArrayList<Integer> list: vertices) {
      for (Integer vertex: list) {
        System.out.println("Vertex " + i + " connected to " + vertex);
      }
      i += 1;
    }

    System.out.println("**************************************");
  }

  void removeEdge(Integer vertex1, Integer vertex2) {
    vertices.get(vertex1).remove(vertex2);

  }
}
