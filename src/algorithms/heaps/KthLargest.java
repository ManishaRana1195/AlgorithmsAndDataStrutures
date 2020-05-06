package algorithms.heaps;

import java.util.PriorityQueue;

public class KthLargest {
    int k;
    java.util.PriorityQueue<Integer> heap;

    public KthLargest(int _k, int[] nums) {
        k = _k;
        heap = new PriorityQueue<>(_k);
        if (nums.length < k) return;
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap.peek()) {
                heap.poll();
                heap.add(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (heap.isEmpty()) {
            heap.add(val);
            return heap.peek();
        }

        // if heap.size >= k
        if (heap.size() >= k) {
            if (val >= heap.peek()) {
                heap.poll();
                heap.add(val);
            }
        } else {
            heap.add(val);
        }
        return heap.peek();
    }
}
