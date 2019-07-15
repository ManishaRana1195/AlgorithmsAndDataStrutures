package datastructures.union_find;

/* Problem Statement - There are N * N grid of sites,
 * Each site is open with probability p,
 * Will the system percolate?
 * System percolates iff top and bottom are connected by open sites*/
public class Percolation {
  private int _numberOfNodes;
  private int[] _nodes;
  private int[] _sizeOfTree;
  private int[] _siteType;

  public Percolation(int numberOfNodes) {
    /*Added two for 2 virtual sites, 0 and n-1 index with virtual top and bottom site*/
    _numberOfNodes = numberOfNodes + 2;
    _nodes = new int[_numberOfNodes];
    _sizeOfTree = new int[_numberOfNodes];
    for (int i = 0; i < _numberOfNodes; i++) {
      _nodes[i] = i;
      _sizeOfTree[i] = 1;
    }
  }

  public void union(int nodeP, int nodeQ) {

  }

  public boolean connected(int nodeP, int nodeQ) {
    return false;
  }

  private int root(int nodeP) {
    return 0;
  }

  public static void main(String[] args) {

  }
}
