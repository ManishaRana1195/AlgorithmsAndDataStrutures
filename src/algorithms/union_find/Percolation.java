package algorithms.union_find;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/* Problem Statement - There are N * N grid of sites,
 * Each site is open with probability p,
 * Will the system percolate?
 * System percolates iff top and bottom are connected by open sites*/
public class Percolation {
  private final WeightedQuickUnionUF quickUnion;
  private boolean[][] grid;
  private int gridSize;
  private int numberOfOpen;

  public Percolation(int numberOfNodes) {
    if (numberOfNodes < 0)
      throw new IllegalArgumentException();

    grid = new boolean[numberOfNodes][numberOfNodes];
    quickUnion = new WeightedQuickUnionUF(numberOfNodes + 2);
    gridSize = numberOfNodes * numberOfNodes;
    numberOfOpen = 0;
  }


  private boolean inRange(int length, int x) {
    return x >= 1 && x <= length;
  }

  // opens the site (row, col) if it is not open already
  public void open(int row, int col) {
    throwErrorIfNotInRange(row, col);

    grid[row][col] = true;
    // find neighbour to connect to
    numberOfOpen += 1;
  }

  private void throwErrorIfNotInRange(int row, int col) {
    int m = grid.length;
    int n = grid[0].length;
    if (!inRange(m, row))
      throw new IndexOutOfBoundsException();

    if (!inRange(n, col))
      throw new IndexOutOfBoundsException();
  }

  private int mapTo1D(int row, int col, int size) {
    return (row - 1) * size + col;
  }

  // is the site (row, col) open?
  public boolean isOpen(int row, int col) {
    throwErrorIfNotInRange(row, col);

    return grid[row][col];
  }

  // is the site (row, col) full?
  public boolean isFull(int row, int col) {
    throwErrorIfNotInRange(row, col);
    int size = grid.length;
    return quickUnion.connected(mapTo1D(row, col, size), 0) || quickUnion.connected(mapTo1D(row, col, size), size);
  }

  // returns the number of open sites
  public int numberOfOpenSites() {
    return numberOfOpen;
  }

  // does the system percolate?
  public boolean percolates() {
    return false;
  }

  // test client (optional)
  public static void main(String[] args) {

  }

}
