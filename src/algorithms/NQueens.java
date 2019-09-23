package algorithms;

import java.util.LinkedList;
import java.util.List;

public class NQueens {

  public static void main(String[] args) {
    List<Pair> queens = new LinkedList<>();

    System.out.println("The result:");
    if (placeQueens(0, queens)) {
      for (Pair pair: queens) {
        System.out.println(pair.row + "," + pair.column);
      }
    }
  }

  private static boolean placeQueens(int column, List<Pair> queens) {
    int numberOfQueens = 4;
    if (column >= numberOfQueens) return true;
    int row = 0;
    while (row < numberOfQueens) {
      Pair rowCol = new Pair(row, column);
      queens.add(rowCol);
      if (isQueenSafe(row, column, queens) && placeQueens(column + 1, queens))
        return true;

      queens.remove(rowCol);
      row += 1;
    }
    return false;
  }

  private static boolean isQueenSafe(int row, int column, List<Pair> queens) {
    for (int i = 0; i < queens.size() - 1; i++) {
      Pair pair = queens.get(i);
      if (row == pair.row || column == pair.column)
        return false;

      if (Math.abs(pair.row - row) == Math.abs(pair.column - column))
        return false;
    }
    return true;
  }
}

class Pair {
  int row;
  int column;

  Pair(int row, int column) {
    this.row = row;
    this.column = column;
  }
}
