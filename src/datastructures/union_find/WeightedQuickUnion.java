package datastructures.union_find;

public class WeightedQuickUnion {
  private int _numberOfNodes;
  private int[] _nodes;
  private int[] _treeSize;

  public WeightedQuickUnion(int numberOfNodes) {
    _numberOfNodes = numberOfNodes;
    _nodes = new int[numberOfNodes];
    _treeSize = new int[numberOfNodes];
    for (int i = 0; i < numberOfNodes; i++) {
      _nodes[i] = i;
      _treeSize[i] = 1;
    }
  }

  /*union method that connects the tree based on the size of the tree.
   * Here, a small tree is linked to the tall tree, that results into tree
   * with less depth and more width*/
  private void union(int nodeP, int nodeQ) {
    int rootP = root(nodeP);
    int rootQ = root(nodeQ);

    if (rootP == rootQ) return;

    int sizeTreeP = _treeSize[rootP]; /* size should be calculated for the root*/
    int sizeTreeQ = _treeSize[rootQ];

    if (sizeTreeP > sizeTreeQ) {
      _nodes[rootQ] = rootP;
      _treeSize[rootQ] += sizeTreeP;
    } else {
      _nodes[rootP] = rootQ;
      _treeSize[rootP] += sizeTreeQ;
    }
  }

  private boolean connected(int nodeP, int nodeQ) {
    return root(nodeP) == root(nodeQ);
  }

  private int root(int nodeP) {
    while (nodeP != _nodes[nodeP])
      nodeP = _nodes[nodeP];

    return nodeP;
  }
}
