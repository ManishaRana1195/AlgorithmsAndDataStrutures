package datastructures.graphs;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board =  {{'a'}};


//                {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}};

        String word = "a" ; //"ABCCED";
        int row = board.length;
        int col = board[0].length;
        boolean[][] isVisited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (performDfs(board, word, i, j, isVisited, 0)) {
                        System.out.println("Found the word");
                        return; // true;
                    }
                }
            }
        }

        return; //false
    }

    private static boolean performDfs(char[][] board, String word, int i, int j, boolean[][] isVisited, int length) {
        if (isInvalid(board, i, j, isVisited)) return false;

        if (word.length() == length) {
            return true;
        }
        System.out.println(board[i][j]);
        System.out.println(word.charAt(length));
        // the key is to break before, whenever there is mismatch
        if (board[i][j] != word.charAt(length)) return false;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        isVisited[i][j] = true;

        for (int[] direction : directions) {
            int currX = i + direction[0];
            int currY = j + direction[1];
            if (!isInvalid(board, currX, currY, isVisited)) {

                if (performDfs(board, word, currX, currY, isVisited, length + 1)) return true;
            }
        }
        isVisited[i][j] = false;
        return false;
    }

    private static boolean isInvalid(char[][] board, int i, int j, boolean[][] isVisited) {
        int row = board.length;
        int col = board[0].length;

        if (i < 0 || j < 0) return true;
        if (i >= row || j >= col) return true;
        if (isVisited[i][j]) return true;

        return false;
    }
}
