package datastructures.trees;


/*
 * Tree is undirected graph, with no cycles
 * each node to connected to another only through one path
 * with N nodes, connected with n-1 edges
 * */
public class BinarySearchTree {
  private Node root;

  public void insertNode(Integer value) {
    Node newNode = new Node(value, null, null);
    if (root == null) {
      root = newNode;
      return;
    }
    Node node = root;
    while (node != null) {
      if (value <= node.getValue()) {
        node = node.getLeftNode();
      }
      if (value > node.getValue()) {
        node = node.getRightNode();
      }

    }
    node.setLeftNode(newNode);
    node.setRightNode(newNode);
  }

  public void deleteNode(Node node) {

  }

  public void print() {

  }

  public static void main(String[] args) {

  }
}

class Node {
  private Integer value;
  private Node leftNode;
  private Node rightNode;

  public Node(Integer value, Node leftNode, Node rightNode) {
    this.value = value;
    this.leftNode = leftNode;
    this.rightNode = rightNode;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public Node getLeftNode() {
    return leftNode;
  }

  public void setLeftNode(Node leftNode) {
    this.leftNode = leftNode;
  }

  public Node getRightNode() {
    return rightNode;
  }

  public void setRightNode(Node rightNode) {
    this.rightNode = rightNode;
  }
}
