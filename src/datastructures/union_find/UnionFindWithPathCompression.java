package datastructures.union_find;

public class UnionFindWithPathCompression {
  private int _numberOfNodes;
  private int[] _nodes;
  private int[] _treeSize;

  public UnionFindWithPathCompression(int numberOfNodes) {
    _numberOfNodes = numberOfNodes;
    _nodes = new int[numberOfNodes];
    _treeSize = new int[numberOfNodes];
    for (int i = 0; i < numberOfNodes; i++) {
      _nodes[i] = i;
      _treeSize[i] = 1;
    }
  }

  public void union(int nodeP, int nodeQ) {
    int rootP = root(nodeP);
    int rootQ = root(nodeQ);

    if (rootP == rootQ) return;

    if (_treeSize[nodeP] > _treeSize[nodeQ]) {
      _treeSize[nodeP] += _treeSize[nodeQ];
      _nodes[nodeQ] = rootP;
    } else {
      _treeSize[nodeQ] += _treeSize[nodeP];
      _nodes[nodeP] = rootQ;
    }
  }

  public boolean connected(int nodeP, int nodeQ) {
    return root(nodeP) == root(nodeQ);
  }

  private int root(int nodeP) {
    while (nodeP != _nodes[nodeP]) {
      /*Path compression the root of P is updated to be grandfather's root*/
      _nodes[nodeP] = _nodes[_nodes[nodeP]];
      nodeP = _nodes[nodeP];
    }

    return nodeP;
  }
}
