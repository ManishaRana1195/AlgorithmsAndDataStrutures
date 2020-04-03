package algorithms.Recursion;

public class SquareSubmatrix {

    public static void main(String[] args) {

        boolean[][] array2D = {{false, true, false, false}, {true, true, true, true}, {false, true, true, false}};
        int row = array2D.length;
        int col = array2D[0].length;
        int maxLength = 0;
        for (int startI = 0; startI < row; startI++) {
            for (int startJ = 0; startJ < col; startJ++) {
                maxLength = Math.max(maxLength, squareSubmatrixArray(array2D, startI, startJ));
            }
        }
        System.out.println("Maximum square having all true:" + maxLength);

        //constructing dp table
        Integer[][] result = new Integer[row][col];
        for (int i = 0; i < col; i++) {
            result[0][i] = array2D[0][i] ? 1 : 0;
        }
        for (int i = 0; i < row; i++) {
            result[i][0] = array2D[i][0] ? 1 : 0;
        }

        for (int startI = 1; startI < row; startI++) {
            for (int startJ = 1; startJ < col; startJ++) {
                maxLength = Math.max(maxLength, squareSubmatrixArrayDP(array2D, startI, startJ, result));
            }
        }

        System.out.println("Maximum square having all true:" + maxLength);
    }

    private static int squareSubmatrixArrayDP(boolean[][] array2D, int endI, int endJ, Integer[][] result) {
        if (isOutOfBounds(array2D, endI, endJ)) return 0;
        if (result[endI][endJ] != null)
            return result[endI][endJ];

        int minTop = result[endI - 1][endJ - 1];
        int minLeft = result[endI - 1][endJ];
        int minRight = result[endI][endJ - 1];
        result[endI][endJ] = 1 + Math.min(Math.min(minRight, minLeft), minTop);

        return result[endI][endJ];
    }

    private static int squareSubmatrixArray(boolean[][] array2D, int startI, int startJ) {
        if (isOutOfBounds(array2D, startI, startJ)) return 0;

        int top = squareSubmatrixArray(array2D, startI + 1, startJ);
        int bottom = squareSubmatrixArray(array2D, startI, startJ + 1);
        int minTopOrBottom = Math.min(top, bottom);
        int oppositeCorner = squareSubmatrixArray(array2D, startI + 1, startJ + 1);

        return 1 + Math.min(minTopOrBottom, oppositeCorner);
    }

    private static boolean isOutOfBounds(boolean[][] array2D, int startI, int startJ) {
        int row = array2D.length;
        int col = array2D[0].length;

        if (startI >= row || startJ >= col) return true;
        if (!array2D[startI][startJ]) return true;
        return false;
    }

}
