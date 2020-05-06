package algorithms.union_find;

class UnionFind {

  private int _numberOfNodes;
  private Integer[] _nodes;

  UnionFind(int numberOfNodes) {
    _numberOfNodes = numberOfNodes;
    _nodes = new Integer[numberOfNodes];
    for (int i = 0; i < numberOfNodes; i++) {
      _nodes[i] = i;
    }
  }

  /* a method that take two nodes and merge their components
  if the nodes are not connected. If nodeP and nodeQ are not
  connected, it takes the id of nodeP and updates where nodeQ
  id is stored*/
  void union(int nodeP, int nodeQ) {
    if (checkNodeWithinRange(nodeP, nodeQ)) return;

    if (!connected(nodeP, nodeQ)) {
      Integer nodeQComponentId = _nodes[nodeQ];
      for (int i = 0; i < _numberOfNodes; i++) {
        if (_nodes[i].equals(nodeQComponentId)) {
          _nodes[i] = _nodes[nodeP];
        }
      }
    }

  }

  private boolean checkNodeWithinRange(int nodeP, int nodeQ) {
    if (nodeP < 0 || _numberOfNodes < nodeP) {
      System.out.println("Node not within range");
      return true;
    }

    if (nodeQ < 0 || _numberOfNodes < nodeQ) {
      System.out.println("Node not within range");
      return true;
    }
    return false;
  }


  boolean connected(int nodeP, int nodeQ) {
    return _nodes[nodeP].equals(_nodes[nodeQ]);
  }

}
