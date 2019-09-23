package datastructures.stacks_queues;

import java.util.Iterator;
import java.util.LinkedList;

class Deque<Item> implements Iterable<Item> {

  private int size;
  private LinkedList<Item> list;

  // construct an empty deque
  private Deque() {
    list = new LinkedList<>();
  }

  // is the deque empty?
  public boolean isEmpty() {
    return size == 0;
  }

  // return the number of items on the deque
  public int size() {
    size = list.size();
    return size;
  }

  // add the item to the front
  private void addFirst(Item item) {
    list.addFirst(item);
  }

  // add the item to the back
  private void addLast(Item item) {
    list.addLast(item);
  }


  /*remove and return the item from the front*/
  private Item removeFirst() {
    return list.removeFirst();
  }

  // remove and return the item from the back
  private Item removeLast() {
    return list.removeLast();
  }

  // return an iterator over items in order from front to back
  public Iterator<Item> iterator() {
    return list.iterator();
  }

  @Override
  public String toString() {
    StringBuilder queue = new StringBuilder();
    for (Item item: list) {
      queue.append(item).append("==>");
    }
    return queue.toString();
  }

  //  unit testing (required)
  public static void main(String[] args) {
    Deque<Integer> deque = new Deque<>();
    deque.addFirst(15);
    deque.addFirst(10);
    deque.addFirst(20);
    deque.addLast(25);
    deque.addFirst(50);
    deque.addLast(40);

    deque.removeFirst();
    deque.removeLast();
    System.out.println("current size:" + deque.size);
    System.out.println(deque);
  }
}
