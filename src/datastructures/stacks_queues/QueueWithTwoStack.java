package datastructures.stacks_queues;

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
    while (rearEnd.size() != 0) {
      frontEnd.push(rearEnd.pop());
    }

    Integer firstNode = frontEnd.pop();
    while (frontEnd.size() != 0) {
      rearEnd.push(frontEnd.pop());
    }
    return firstNode;
  }

  public Integer peekFront() {
    while (rearEnd.size() != 0) {
      frontEnd.push(rearEnd.pop());
    }

    Integer firstNode = frontEnd.peek();
    while (frontEnd.size() != 0) {
      rearEnd.push(frontEnd.pop());
    }


    return firstNode;
  }

  public Integer peekEnd() {
    return rearEnd.peek();
  }


  @Override
  public String toString() {
    StringBuilder queueContains = new StringBuilder();
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

    queue.remove();
    queue.remove();

    queue.add(30);
    queue.add(40);
    System.out.println(queue);
    System.out.println(queue.peekEnd());
    System.out.println(queue.peekFront());
  }
}
