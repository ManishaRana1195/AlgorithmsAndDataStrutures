package algorithms.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
  private List<ArrayList<Integer>> vertices;
  private int numberOfVertices;

  public int getNumberOfVertices() {
    return numberOfVertices;
  }

  public Graph(int numberOfVertices) {
    vertices = new LinkedList<>();
    for (int i = 0; i < numberOfVertices; i++) {
      vertices.add(i, new ArrayList<>());
    }
    this.numberOfVertices = numberOfVertices;

  }

  public void addDirectedEdge(int vertex1, int vertex2) {
    vertices.get(vertex1).add(vertex2);
  }

  void addUndirectedEdge(int vertex1, int vertex2) {
    vertices.get(vertex1).add(vertex2);
    vertices.get(vertex2).add(vertex1);
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

  public List<Integer> getAdjacentNodes(Integer node) {
    return vertices.get(node);
  }
}
