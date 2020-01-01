package algorithms;

public class MaxAreaOfIslands {


  public static void main(String[] args) {
    int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

    int maxArea = maxAreaOfIsland(grid);
    System.out.println("Max area: " + maxArea);
  }

  private static int maxAreaOfIsland(int[][] grid) {
    int max = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        int currentMax = 0;
        if (grid[i][j] == 1) {
          currentMax = dfs(grid, i, j);
        }

        if (currentMax > max) {
          max = currentMax;
        }

      }
    }
    return max;
  }

  private static int dfs(int[][] grid, int x, int y) {

    if (x < 0 || y < 0) return 0;
    if (x >= grid.length || y >= grid[0].length)
      return 0;

    if (grid[x][y] != 1)
      return 0;

    grid[x][y] = 0;

    return 1+ dfs(grid, x + 1, y) + dfs(grid, x - 1, y) +
        dfs(grid, x, y + 1) + dfs(grid, x, y - 1);
  }
}
