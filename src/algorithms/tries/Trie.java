package algorithms.tries;

import java.util.ArrayList;
import java.util.List;

public class Trie {
  private Node root;

  Trie() {
    root = new Node(null, 0);
  }


  private void insertNode(String word) {
    Node head = root;
    for (int i = 0; i < word.length(); i++) {
      char current = word.charAt(i);
      Node nodeAtIndex = head.next(current);
      if (nodeAtIndex == null) {
        head.children[current - 'a'] = new Node(head, 0);
      }
      head = head.next(word.charAt(i));
    }
    head.lastCharacterCount += 1;
  }

  // do print later

  private Node search(String word) {
    Node head = this.root;
    int i = 0;
    while (i != word.length()) {
      Node currentNode = head.next(word.charAt(i));
      i++;
      if (currentNode != null)
        head = currentNode;
      else
        return null;
    }
    return head;
  }

  /*
   * 1. search for the word
   * 2. decrease the number of occurrences
   * 3. delete node if it has no child and its occurrence is 0
   * 4. find parent node, repeat step 3*/
  private void deleteWord(String word) {
    Node node = search(word);
    if (node == null) {
      System.out.println("cannot delete word. No such word exists.");
      return;
    }

    node.lastCharacterCount -= 1;
    while (node.lastCharacterCount == 0) {
      if (node.children == null) {

      }

    }

  }

  public static void main(String[] args) {
    List<String> inputList = new ArrayList<>();
    inputList.add("abba");
    inputList.add("blaah");
    inputList.add("abbey");
    inputList.add("abba");
    inputList.add("baah");
    Trie trie = new Trie();
    inputList.forEach(trie::insertNode);
    System.out.println(trie.search("abba").lastCharacterCount);
    System.out.println(trie.search("baah").lastCharacterCount);
    System.out.println(trie.search("abbey").lastCharacterCount);

  }


}

class Node {
  Node parent;
  int lastCharacterCount;
  Node[] children;

  Node(Node parent, int lastCharacterCount) {
    this.parent = parent;
    this.lastCharacterCount = lastCharacterCount;
    this.children = new Node[26];
  }

  public Node next(char c) {
    return children[c - 'a'];
  }
}
