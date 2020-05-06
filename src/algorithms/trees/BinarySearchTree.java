package algorithms.trees;


import java.util.HashMap;
import java.util.LinkedList;

/*
 * Tree is undirected graph, with no cycles
 * each node to connected to another only through one path
 * with N nodes, connected with n-1 edges
 * */
public class BinarySearchTree {

  private Node root = null;

  private void insertNode(Integer value) {
    Node newNode = new Node(value, null, null);
    root = insert(root, newNode);
  }

  private Node insert(Node node, Node newNode) {
    if (node == null) {
      node = newNode;
    } else if (newNode.getValue() <= node.getValue()) {
      node.setLeftNode(insert(node.getLeftNode(), newNode));
    } else {
      node.setRightNode(insert(node.getRightNode(), newNode));
    }

    return node;
  }

  public void deleteNode(int searchNode) {
    delete(root, searchNode);
  }

  /*1. Find the element that needs to be deleted
   * 2. Replace that element with the appropriate child element*/
  private Node delete(Node node, Integer searchNode) {
    if (root == null) {
      return null;
    }

    if (searchNode < node.getValue()) {
      node.setLeftNode(delete(node.getLeftNode(), searchNode));
    } else if (searchNode > node.getValue()) {
      node.setRightNode(delete(node.getRightNode(), searchNode));
    } else {
      /* you have reached the point to delete the node. We have three cases to delete a node.
        1. if the node is leaf node
        2. if the node has either left of right child
        3. if the node has both the child nodes
        4. if the node does not exist in the tree

*/
      if (node.getLeftNode() == null) {
        Node rightChild = node.getRightNode();
        node.setValue(null);
        node = null;
        return rightChild;
      } else if (node.getRightNode() == null) {
        Node leftChild = node.getLeftNode();
        node.setValue(null);
        node = null;
        return leftChild;
      } else {
        Node smallestRightNode = digLeft(node.getRightNode());
        node.setValue(smallestRightNode.getValue());
        node.setRightNode(delete(node.getRightNode(), smallestRightNode.getValue()));
      }
    }
    return node;
  }

  private Node digLeft(Node rightNode) {
    Node node = rightNode;
    while (node.getLeftNode() != null) {
      node = node.getLeftNode();
    }
    return node;
  }


  /*to get prefix expression on of an expression tree*/
  private void preorder(Node node) {
    if (node == null) return;
    System.out.println(node.getValue());
    preorder(node.getLeftNode());
    preorder(node.getRightNode());
  }

  /* postfix expression of an expression tree */
  private void postorder(Node node) {
    if (node == null) return;

    postorder(node.getLeftNode());
    postorder(node.getRightNode());
    System.out.println(node.getValue());
  }

  /* to get nodes of tree in sorted order*/
  private void inorder(Node node) {
    if (node == null) return;
    inorder(node.getLeftNode());
    System.out.println(node.getValue());
    inorder(node.getRightNode());
  }

  private void levelOrder() {
    LinkedList<Node> visitedNodes = new LinkedList<>();
    HashMap<Integer, Boolean> isVisited = new HashMap<>();
    visitedNodes.push(root);
    breadthFirstSearch(isVisited, visitedNodes);
  }

  private void breadthFirstSearch(HashMap<Integer, Boolean> isVisited, LinkedList<Node> visitedNodes) {
    while (!visitedNodes.isEmpty()) {
      Node currentNode = visitedNodes.remove();
      if (currentNode != null && !isVisited.getOrDefault(currentNode.getValue(), false)) {
        System.out.println(" " + currentNode.getValue());
        isVisited.put(currentNode.getValue(), true);
        visitedNodes.push(currentNode.getLeftNode());
        visitedNodes.push(currentNode.getRightNode());
        breadthFirstSearch(isVisited, visitedNodes);
      }
    }
  }

  public void print() {
    System.out.println("Nodes in the BST:");
    inorder(this.root);
  }


  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insertNode(50);
    tree.insertNode(80);
    tree.insertNode(40);
    tree.insertNode(70);
    tree.insertNode(10);
    tree.insertNode(15);
    tree.insertNode(230);
    tree.print();
    System.out.println("***************************************************************");

    tree.levelOrder();
  }
}

class Node {
  Integer value;
  Node leftNode;
  Node rightNode;

  public Node(Integer value){
    this(value,null,null);
  }

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
