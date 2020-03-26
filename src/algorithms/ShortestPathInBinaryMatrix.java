package algorithms;

import java.util.LinkedList;
import java.util.List;

public class ShortestPathInBinaryMatrix {
    int nodes_in_next_layer;

    public static void main(String[] args) {
        Integer[][] matrix = {{1, 1, 1, 1}, {0, 1, 0, 1}, {1, 1, 1, 1}};
        Integer[][] matrix2 = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}};


        ShortestPathInBinaryMatrix thisClass = new ShortestPathInBinaryMatrix();
        int pathLength = thisClass.binaryFirstSearch(matrix, 2, 0);
        System.out.println("Path length 2: " + pathLength);
    }

    private int binaryFirstSearch(Integer[][] matrix, int tr, int tc) {
        LinkedList<int[]> nodesToBeVisited = new LinkedList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] isVisited = new boolean[row][col];
        int srcX = 0;
        int srcY = 0;

        nodesToBeVisited.add(new int[]{srcX, srcY});
        int minPathLength = 0;
        isVisited[srcX][srcY] = true;

        while (!nodesToBeVisited.isEmpty()) {
            int size = nodesToBeVisited.size();
            while (size > 0) {
                int[] currentNode = nodesToBeVisited.removeFirst();
                int currentX = currentNode[0];
                int currentY = currentNode[1];

                if (currentX == tr && currentY == tc) {
                    return minPathLength;
                }
                List<int[]> adjacentNodes = findAdjacentNodes(currentNode, matrix);
                for (int[] neighbor : adjacentNodes) {
                    if (!isVisited[neighbor[0]][neighbor[1]]) {
                        nodesToBeVisited.add(neighbor);
                        isVisited[neighbor[0]][neighbor[1]] = true;
                    }
                }

                size--;
                if (size == 0) {
                    minPathLength += 1;
                }
            }


        }

        return -1;
    }

    private List<int[]> findAdjacentNodes(int[] currentNode, Integer[][] matrix) {
        LinkedList<int[]> neighbors = new LinkedList<>();
        int row = matrix.length;
        int col = matrix[0].length;

        int m = currentNode[0];
        int n = currentNode[1];

        int[] rows = new int[]{-1, 0, 0, 1};
        int[] cols = new int[]{0, -1, 1, 0};

        for (int i = 0; i < rows.length; i++) {
            int x = m + rows[i];
            int y = n + cols[i];

            if (0 > x || 0 > y) continue;
            if (row <= x || col <= y) continue;

            if (matrix[x][y] == 0) continue;

            neighbors.add(new int[]{x, y});
        }
        return neighbors;
    }


}
