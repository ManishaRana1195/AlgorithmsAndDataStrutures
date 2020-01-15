package datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class QueensAttackTheKing {

    public static void main(String[] args) {
        int[][] queens = {{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}};
        int[] king = {0, 0};

        List<List<Integer>> queensCanAttack = queensAttacktheKing(queens, king);
        System.out.println("Queens that can attack the king");
        for (List<Integer> coords : queensCanAttack) {
            System.out.println("x: " + coords.get(0) + ", y: " + coords.get(1));
        }
    }

    public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList<>();
        int[][] matrix = new int[8][8];

        for (int[] coords : queens) {
            int x = coords[0];
            int y = coords[1];
            matrix[x][y] = 1;
        }
        int kingX = king[0];
        int kingY = king[1];
        matrix[kingX][kingY] = 2;

        while (kingX >= 0 && kingY >= 0) {
            if (saveQueen(result, matrix[kingX][kingY], kingX, kingY)) break;
            kingX -= 1;
            kingY -= 1;
        }

        kingX = king[0];
        kingY = king[1];
        while (kingX < 8 && kingY < 8) {
            if (saveQueen(result, matrix[kingX][kingY], kingX, kingY)) break;
            kingX += 1;
            kingY += 1;
        }

        kingX = king[0];
        kingY = king[1];
        while (kingX < 8 && kingY >= 0) {
            if (saveQueen(result, matrix[kingX][kingY], kingX, kingY)) break;
            kingX += 1;
            kingY -= 1;
        }

        kingX = king[0];
        kingY = king[1];
        while (kingX >= 0 && kingY < 8) {
            if (saveQueen(result, matrix[kingX][kingY], kingX, kingY)) break;
            kingX -= 1;
            kingY += 1;
        }


        kingX = king[0];
        kingY = king[1];
        while (kingY < 8) {
            if (saveQueen(result, matrix[kingX][kingY], kingX, kingY)) break;
            kingY += 1;
        }


        kingX = king[0];
        kingY = king[1];
        while (kingY >= 0) {
            if (saveQueen(result, matrix[kingX][kingY], kingX, kingY)) break;
            kingY -= 1;
        }


        kingX = king[0];
        kingY = king[1];
        while (kingX < 8) {
            if (saveQueen(result, matrix[kingX][kingY], kingX, kingY)) break;
            kingX += 1;
        }


        kingX = king[0];
        kingY = king[1];
        while (kingX >= 0) {
            if (saveQueen(result, matrix[kingX][kingY], kingX, kingY)) break;
            kingX -= 1;
        }


        return result;
    }

    private static boolean saveQueen(List<List<Integer>> result, int isQueen, int kingX, int kingY) {
        if (isQueen == 1) {
            ArrayList<Integer> queen = new ArrayList<>();
            queen.add(kingX);
            queen.add(kingY);
            result.add(queen);
            return true;
        }
        return false;
    }
}
