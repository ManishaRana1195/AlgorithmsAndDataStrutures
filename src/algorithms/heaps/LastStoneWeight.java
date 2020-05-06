package algorithms.heaps;

import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {

        int[] arr = {1,3};
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((o1, o2) -> {
            if (o2.equals(o1)) return 0;
            if (o2 > o1) return 1;
            return -1;
        });

        for (int val : arr) {
            maxheap.add(val);
        }

        while(maxheap.size()>1){
            int y = maxheap.poll();
            int x = maxheap.poll();
            if(x == y) continue;
            maxheap.add(y-x);
            System.out.println(y-x);
        }

        System.out.println(maxheap.peek());

    }
}
