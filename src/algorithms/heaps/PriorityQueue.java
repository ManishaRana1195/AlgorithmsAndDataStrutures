package algorithms.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * Similar to queue, where each element has a certain priority,
 * thus, it should contain elements that are comparable,
 * so that we can sort the elements in ascending/descending order.
 *
 * PQ is implemented in either maxHeap or minHeap*/

/*Implementing Max heap, a binary tree with max heap invariant*/
class PriorityQueue<P> {

    private int heapSize = 0;
    private List<Integer> heap;

    public PriorityQueue() {
        this.heapSize = 0;
        this.heap = new ArrayList<>();
    }

    public PriorityQueue(int heapSize) {
        this.heapSize = heapSize;
        this.heap = new ArrayList<>(heapSize);
    }

    /*Search an element and returns its index, else -1,
        * you can use map instead to search with O(n)*/
    public int search(Integer element) {
        for (int index = 0; index < heapSize; index++) {
            if (Objects.equals(element, heap.get(index)))
                return index;
        }
        return -1;
    }

    public void insert(Integer element) {
        if (element == null) {
            System.out.println("Error input element null");
            return;
        }
        if (heapSize == 0) {
            heap.add(element);
            heapSize += 1;
        } else {
            /*adding to the tail*/
            heap.add(element);
            shiftUp(element, heapSize);
            heapSize += 1;
        }
    }

    private void shiftUp(Integer element, int currentIndex) {
        int parentIndex = getParent(currentIndex);
        while (heap.get(parentIndex) < element) {
            swap(parentIndex, currentIndex);
            currentIndex = parentIndex;
            parentIndex = getParent(parentIndex);
        }
    }

    private int getParent(int childIndex) {
        return (childIndex - 1) / 2;
    }

    /*poll element from the top of the heap*/
    public Integer poll() {
        if (heapSize < 0) return null;

        Integer topMostElement = heap.get(0);
        Integer lastElement = heap.get(heapSize - 1);
        heap.set(0, lastElement);
        heap.set(heapSize - 1, null);
        heapSize -= 1;

        shiftDown(heap.get(0), 0);

        return topMostElement;
    }

    private void shiftDown(Integer currentValue, int currentIndex) {
        while (true) {
            int left = 2 * currentIndex + 1;
            int right = 2 * currentIndex + 2;

            int largest = right <= heapSize && heap.get(left)
                    < heap.get(right) ? right : left;

            if (left >= heapSize || heap.get(largest) < currentValue)
                break;

            swap(currentIndex, largest);
            currentIndex = largest;
        }
    }

    private void swap(int maxChildIndex, int currentIndex) {
        int temp = heap.get(currentIndex);
        heap.set(currentIndex, heap.get(maxChildIndex));
        heap.set(maxChildIndex, temp);
    }

    private Integer getMaxChildIndex(int currentIndex) {
        int leftChildIndex = 2 * currentIndex + 1;
        int rightChildIndex = 2 * currentIndex + 2;

        if (leftChildIndex > heapSize) {
            return null;
        }

        if (rightChildIndex > heapSize) {
            return leftChildIndex;
        }

        return heap.get(leftChildIndex) > heap.get(rightChildIndex) ? leftChildIndex : rightChildIndex;
    }

    public Integer peek() {
        if (heapSize <= 0) return null;
        return heap.get(0);
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.insert(10);
        pq.insert(5);
        pq.insert(30);
        System.out.println(pq.peek());

        pq.insert(25);
        pq.insert(35);
        pq.insert(60);
        System.out.println(pq.peek());

        pq.insert(65);
        pq.insert(40);
        pq.insert(50);
        System.out.println(pq.peek());

        System.out.println("****************************************");
        pq.print();
        System.out.println("****************************************");

        pq.poll();

        pq.poll();
        pq.poll();
        pq.poll();
        System.out.println(pq.peek());

    }

    private void print() {
        heap.forEach(System.out::println);
    }
}
