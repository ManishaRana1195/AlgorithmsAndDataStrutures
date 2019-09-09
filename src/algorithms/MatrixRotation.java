package algorithms;

public class MatrixRotation {

  public static void main(String[] args) {
    int[][] matrix = {{1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}};

    int[][] rotatedMatrix = rotateMatrix(matrix);

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
