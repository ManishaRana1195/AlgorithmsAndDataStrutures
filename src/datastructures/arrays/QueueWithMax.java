package datastructures.arrays;

import java.util.LinkedList;

public class QueueWithMax {

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.print();
        queue.max();

        queue.enqueue(4);
        queue.enqueue(2);
        queue.max();
        queue.enqueue(3);
        queue.enqueue(5);
        queue.print();

        queue.dequeue();
        queue.max();
        queue.print();

    }
}

class Queue {
    private LinkedList<Integer> queue;
    private LinkedList<Integer> max;

    public Queue() {
        queue = new LinkedList<>();
        max = new LinkedList<>();
    }

    public void enqueue(Integer element) {
        while (!max.isEmpty() && element > max.peekLast()) {
            max.removeLast();
        }
        max.add(element);

        queue.add(element);
    }

    public Integer dequeue() {
        if (queue.isEmpty()) return null;

        if (queue.peek().equals(max.peek())) {
            queue.removeFirst();
            return max.removeFirst();
        }

        return queue.removeFirst();
    }

    public void print() {
        System.out.println("The queue contains: ");
        for (Integer element : queue) {
            System.out.print(element + "\t");
        }
        System.out.println();
    }

    public Integer max() {
        if (max.isEmpty()) return null;
        System.out.println("The max element is:" + max.peekFirst());
        return max.peekFirst();
    }
}
