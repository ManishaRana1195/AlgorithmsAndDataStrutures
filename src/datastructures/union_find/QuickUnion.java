package datastructures.union_find;

public class QuickUnion {

  private int _numberOfNodes;
  private int[] _nodes;

  QuickUnion(int numberOfNodes) {
    _numberOfNodes = numberOfNodes;
    _nodes = new int[numberOfNodes];
    for (int i = 0; i < _numberOfNodes; i++) {
      _nodes[i] = i;
    }
  }

  /*a method which find the root of  node P and Q and
   updates the root of node P to that of node Q*/
  private void union(int nodeP, int nodeQ) {
    if (!connected(nodeP, nodeQ)) {
      int rootP = root(nodeP);
      int rootQ = root(nodeQ);
      _nodes[rootP] = rootQ;
    }
  }

  private boolean connected(int nodeP, int nodeQ) {
    return root(nodeP) == root(nodeQ);
  }

  private int root(int nodeP) {
    while (nodeP != _nodes[nodeP]) {
      nodeP = _nodes[nodeP];
    }

    return nodeP;
  }
}
