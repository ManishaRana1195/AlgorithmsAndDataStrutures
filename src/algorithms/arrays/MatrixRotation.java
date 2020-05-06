package algorithms.arrays;

public class MatrixRotation {

  public static void main(String[] args) {
    int[][] matrix = {{1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}};

    int[][] rotatedMatrix = rotateMatrix(matrix);
    printMatrix(rotatedMatrix);
    System.out.println("*************************");
    matrix = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
    };
    int length = matrix.length;
    for (int layer = 0; layer < length / 2; layer++) {
      rotateByLayer(matrix, layer, length - 1 - layer);
    }
    printMatrix(matrix);
  }

  private static void rotateByLayer(int[][] matrix, int start, int end) {
    int len = matrix.length - 1;
    for (int j = start; j < end; j++) {
      int temp = matrix[j][start];
      matrix[j][start] = matrix[end][j];
      matrix[end][j] = matrix[len - j][end];
      matrix[len - j][end] = matrix[start][len - j];
      matrix[start][len - j] = temp;
    }
  }

  private static void printMatrix(int[][] rotatedMatrix) {
    for (int i = 0; i < rotatedMatrix.length; i++) {
      for (int j = 0; j < rotatedMatrix.length; j++) {
        System.out.print(rotatedMatrix[i][j] + "\t");
      }
      System.out.println();
    }
  }

  private static int[][] rotateMatrix(int[][] matrix) {
    int len = matrix.length;

    for (int layer = 0; layer < len / 2; layer++) {
      int last = len - 1 - layer;
      for (int i = layer; i < last; i++) {
        int offset = i - layer;
        int temp = matrix[layer][i];

        // left array into top
        matrix[layer][i] = matrix[last - offset][layer];
        //  bottom array to left
        matrix[last - offset][layer] = matrix[last][last - offset];

        //right array to bottom
        matrix[last][last - offset] = matrix[i][last];

        // top to right array
        matrix[i][last] = temp;
      }
    }


    return matrix;
  }
}
