package algorithms.graphs;

public class NumberOfIslands {

  public static void main(String[] args) {

    Integer graph[][] = {
        {1, 1, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 0, 1, 1}};

    System.out.println("Number of islands: " + countIslands(graph));
  }

  private static Integer countIslands(Integer[][] graph) {
    int count = 0;
    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph.length; j++) {
        if (graph[i][j] == 1) {
          dfsTraversal(graph, i, j);
          count += 1;
        }
      }
    }
    return count;
  }

  private static void dfsTraversal(Integer[][] graph, int i, int j) {
    if (i < 0 || j < 0)
      return;

    if (i >= graph.length || j >= graph.length)
      return;

    if (graph[i][j] != 1)
      return;

    graph[i][j] = 0;
    dfsTraversal(graph, i + 1, j + 1);
    dfsTraversal(graph, i - 1, j - 1);
    dfsTraversal(graph, i + 1, j - 1);
    dfsTraversal(graph, i - 1, j + 1);

  }

}
