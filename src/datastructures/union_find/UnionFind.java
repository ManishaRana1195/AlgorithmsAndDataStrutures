package datastructures.union_find;

public class UnionFind {

  private int _numberOfNodes;
  private Integer[] _nodes;

  UnionFind(int numberOfNodes) {
    _numberOfNodes = numberOfNodes;
    _nodes = new Integer[numberOfNodes];
    for (int i = 0; i < numberOfNodes; i++) {
      _nodes[i] = i;
    }
  }

  void union(int nodeP, int nodeQ) {
    if (nodeP < 0 || _numberOfNodes < nodeP) {
      System.out.println("Node not within range");
      return;
    }

    if (nodeQ < 0 || _numberOfNodes < nodeQ) {
      System.out.println("Node not within range");
      return;
    }

    if (!connected(nodeP, nodeQ)) {
      Integer nodeQComponentId = _nodes[nodeQ];
      for (int i = 0; i < _numberOfNodes; i++) {
        if (_nodes[i].equals(nodeQComponentId)) {
          _nodes[i] = _nodes[nodeP];
        }
      }
    }

  }


  boolean connected(int nodeP, int nodeQ) {
    return _nodes[nodeP].equals(_nodes[nodeQ]);
  }
  
}
