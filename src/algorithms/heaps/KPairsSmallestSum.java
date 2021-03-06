package algorithms.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsSmallestSum {

    public static void main(String[] args) {
        kSmallestPairs(null, null, 0);

    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        nums1 = new int[]{1,1,2};
        nums2 = new int[]{1,2,3};
        k = 3;
        List<List<Integer>> result = new ArrayList<>();
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 == 0 || length2 == 0) return result;

        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o2.sum - o1.sum);
        int i = 0, j = 0, counter = 0;
        for (; i < length1; i++) {
            j = 0;
            for (; j < length2; j++) {
                pq.add(new Pair(nums1[i], nums2[j]));
                counter++;
                if (counter == k) {
                    break;
                }
            }
            if (counter == k) {
                break;
            }
        }

        System.out.println(pq.size());
        if (j >= length2) {
            i += 1;
            j = 0;
        }

        for (int l = i; l < length1; l++) {
            for (int m = j; m < length2; m++) {
                int sum = nums1[l] + nums2[m];
                if (sum <= pq.peek().sum) {
                    pq.poll();
                    pq.add(new Pair(nums1[l], nums2[m]));
                }
            }
        }

        while (pq.size() > 0) {
            Pair pair = pq.poll();
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(pair.num1);
            temp.add(pair.num2);
            System.out.println(pair.num1 + ", " + pair.num2);
            result.add(temp);
        }


        return result;
    }


}

class Pair {
    int num1;
    int num2;
    int sum;

    public Pair(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
        sum = num1 + num2;
    }
}
