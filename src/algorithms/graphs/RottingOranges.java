package algorithms.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};

        int row = grid.length;
        if (row == 0) return;//0;
        int col = grid[0].length;

        Set<Pair> freshOranges = new HashSet<>();
        Queue<Pair> rottenOranges = new LinkedList<>();

        separateFreshAndRottenOranges(grid, freshOranges, rottenOranges);
        int minutesCount = getMinutesCount(row, col, freshOranges, rottenOranges);

        System.out.println(minutesCount);
        // return minuteCount;
    }

    private static int getMinutesCount(int row, int col, Set<Pair> freshOranges, Queue<Pair> rottenOranges) {
        int minutesCount = 0;

        while (!freshOranges.isEmpty()) {
            Queue<Pair> infected = new LinkedList<>();
            while (!rottenOranges.isEmpty()) {
                Pair rotten = rottenOranges.poll();
                Queue<Pair> neighbors = getRottenNeighbors(rotten, freshOranges, row, col);
                for (Pair rottenNeighbor : neighbors) {
                    freshOranges.remove(rottenNeighbor);
                    infected.add(rottenNeighbor);
                }

            }
            minutesCount += 1;
            rottenOranges = infected;

            if (infected.isEmpty() && freshOranges.size() > 0) {
                return -1;
            }
        }
        return minutesCount;
    }

    private static void separateFreshAndRottenOranges(int[][] grid, Set<Pair> freshOranges, Queue<Pair> rottenOranges) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshOranges.add(new Pair(i, j));
                } else if (grid[i][j] == 2) {
                    rottenOranges.add(new Pair(i, j));
                }
            }
        }
    }

    private static Queue<Pair> getRottenNeighbors(Pair rotten, Set<Pair> freshOranges, int totalRow, int totalCol) {
        Queue<Pair> neigbors = new LinkedList<>();
        int x = rotten.x;
        int y = rotten.y;

        int[][] directions = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};
        for (int[] dir : directions) {
            int currentX = x + dir[0];
            int currentY = y + dir[1];
            if (notWithinBounds(currentX, currentY, totalRow, totalCol)) {
                Pair pair = new Pair(currentX, currentY);
                if (freshOranges.contains(pair)) {
                    neigbors.add(pair);
                }
            }

        }

        return neigbors;
    }

    private static boolean notWithinBounds(int currentX, int currentY, int totalRow, int totalCol) {
        if (0 > currentX || 0 > currentY) return false;
        if (totalRow <= currentX || totalCol <= currentY) return false;
        return true;
    }

}


