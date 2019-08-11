package datastructures.union_find;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithmUnionFind {

  public static void main(String[] args) {
    List<Edge> inputEdges = Arrays.asList(
        new Edge(0, 1, 5),
        new Edge(0, 3, 9),
        new Edge(0, 4, 1),
        new Edge(1, 2, 4),
        new Edge(1, 3, 2),
        new Edge(2, 7, 4),
        new Edge(2, 8, 1),
        new Edge(2, 9, 8),
        new Edge(3, 4, 2),
        new Edge(3, 5, 4),
        new Edge(3, 6, 11),
        new Edge(3, 7, 2),
        new Edge(4, 5, 1),
        new Edge(5, 6, 7),
        new Edge(6, 7, 1),
        new Edge(6, 8, 4),
        new Edge(7, 8, 6),
        new Edge(8, 9, 0)
    );

    System.out.println("Number of nodes: 10 ");
    System.out.println("Following are the edges and their cost in the graph:");
    printGraph(inputEdges);
    Collections.sort(inputEdges);

    UnionFindWithPathCompression unionFind = new UnionFindWithPathCompression(10);
    int minSum = 0;
    for (Edge edge: inputEdges) {
      int start = edge.getStart();
      int end = edge.getEnd();
      if (!unionFind.connected(start, end)) {
        unionFind.union(start, end);
        minSum += edge.getCost();
      }
    }

    System.out.println("The sum of minimum spanning tree is:" + minSum);
  }

  private static void printGraph(List<Edge> inputEdges) {
    for (Edge edge: inputEdges) {
      System.out.println("From " + edge.getStart() + " to " + edge.getEnd() + ", cost:" + edge.getCost());
    }
  }


}

class Edge implements Comparable<Edge> {
  private int start;
  private int end;

  public int getCost() {
    return cost;
  }

  private int cost;

  public Edge(int start, int end, int cost) {
    this.start = start;
    this.end = end;
    this.cost = cost;
  }


  @Override
  public int compareTo(Edge edge) {
    return this.cost - edge.getCost();
  }

  public int getStart() {
    return start;
  }

  public int getEnd() {
    return end;
  }
}


