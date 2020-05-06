package algorithms.graphs;

public class PathWithMaximumGold {

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 7, 0, 0, 0},
                {2, 0, 6, 0, 1, 0}, {3, 5, 6, 7, 4, 2},
                {4, 3, 1, 0, 2, 0}, {3, 0, 5, 0, 20, 0}};

        int col = grid[0].length;
        int row = grid.length;
        boolean[][] isVisited = new boolean[row][col];

        int maxPath = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) continue;
                else {
                    maxPath = Math.max(maxPath, doBFS(i, j, isVisited, grid));
                }
                isVisited = new boolean[row][col];
            }
        }

        System.out.println("The path with maximum gold is:" + maxPath);

    }

    private static int doBFS(int i, int j, boolean[][] isVisited, int[][] grid) {

        if (isInvalid(i, j, isVisited, grid)) return 0;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int maxPath = 0;
        isVisited[i][j] = true;
        for (int[] direction : directions) {
            int currX = i + direction[0];
            int currY = j + direction[1];
            if (!isInvalid(currX, currY, isVisited, grid)) {
                int currentPath = doBFS(currX, currY, isVisited, grid);
                maxPath = Math.max(maxPath, currentPath);
            }
        }
        isVisited[i][j] = false;  // important
        return grid[i][j] + maxPath;
    }

    private static boolean isInvalid(int i, int j, boolean[][] isVisited, int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        if (i < 0 || row <= i) return true;
        if (j < 0 || col <= j) return true;
        if (isVisited[i][j]) return true;
        if (grid[i][j] == 0) return true;

        return false;
    }
}
