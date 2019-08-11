package datastructures.stacks_queues;

import java.util.EmptyStackException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueWithTwoStack {
  private Stack<Integer> frontEnd;
  private Stack<Integer> rearEnd;

  public QueueWithTwoStack() {
    frontEnd = new Stack<>();
    rearEnd = new Stack<>();
  }

  public void add(Integer element) {
    rearEnd.push(element);
  }

  public Integer remove() {
    if (frontEnd.isEmpty() && rearEnd.isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }

    if (frontEnd.isEmpty()) {
      while (rearEnd.size() != 0) {
        frontEnd.push(rearEnd.pop());
      }
    }
    return frontEnd.pop();
  }

  public Integer peekFront() {
    if (frontEnd.isEmpty() && rearEnd.isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }

    if (frontEnd.isEmpty()) {
      while (rearEnd.size() != 0) {
        frontEnd.push(rearEnd.pop());
      }
    }

    return frontEnd.peek();
  }

  public Integer peekEnd() {
    return rearEnd.peek();
  }


  @Override
  public String toString() {
    StringBuilder queueContains = new StringBuilder();
    ListIterator<Integer> iter = frontEnd.listIterator(frontEnd.size());
    while (iter.hasPrevious()) {
      queueContains.append(iter.previous()).append(" ==> ");
    }

    for (Integer value: rearEnd) {
      queueContains.append(value).append(" ==> ");
    }

    return queueContains.toString();
  }

  public static void main(String[] args) {
    QueueWithTwoStack queue = new QueueWithTwoStack();
    queue.add(5);
    queue.add(10);
    queue.add(16);
    queue.add(20);
    System.out.println(queue);

    queue.remove();
    queue.remove();

    queue.add(30);
    queue.add(40);
    System.out.println(queue);
    System.out.println(queue.peekEnd());
    System.out.println(queue.peekFront());
  }
}
