package algorithms.Recursion;

/*Is there a path from top left to bottom right  corner,
*   0 represents path and 1 represents wall*/
public class MazeProblem {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 1, 1, 1}, {0, 0, 0, 1}, {1, 0, 0, 1}, {1, 1, 0, 0}};
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        boolean doesPathExist = doesPathExist(grid, 0, 0, isVisited);
        System.out.println("Path exists from top left to bottom right  corner: " + doesPathExist);
    }

    private static boolean doesPathExist(int[][] grid, int x, int y, boolean[][] isVisited) {
        int row = grid.length;
        int col = grid[0].length;

        if (isOutOfBounds(x, y, row, col) || grid[x][y] == 1 || isVisited[x][y]) return false;
        if (x == row - 1 && y == col - 1) return true;

        isVisited[x][y] = true;
        return doesPathExist(grid, x + 1, y, isVisited) ||
                doesPathExist(grid, x - 1, y, isVisited) ||
                doesPathExist(grid, x, y + 1, isVisited) ||
                doesPathExist(grid, x, y - 1, isVisited);
    }

    private static boolean isOutOfBounds(int x, int y, int row, int col) {
        if (x < 0 || y < 0) return true;
        return x >= row || y >= col;
    }
}
