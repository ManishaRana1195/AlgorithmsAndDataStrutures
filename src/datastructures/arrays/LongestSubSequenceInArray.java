package datastructures.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class LongestSubSequenceInArray {

    public static void main(String[] args) {
        //int[] input = {100, 4, 200, 1, 3, 2};
        int[] input = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};

        int longest = 1;

        longest = getLongestSubSequenceUsingMemo(input, longest);
        System.out.println("Length of longest subsequence using Recursion: " + longest);

        longest = getLongestSubsequenceLengthUsingPQ(input);
        System.out.println("Length of longest subsequence using PQ: " + longest);

    }

    private static int getLongestSubSequenceUsingMemo(int[] input, int longest) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer element : input) {
            set.add(element);
        }
        for (int anInput : input) {
            int count = getLongestLengthRecursion(anInput, map, set);
            longest = Math.max(count, longest);
        }
        return longest;
    }

    private static int getLongestLengthRecursion(int currValue, HashMap<Integer, Integer> memo,
                                                 HashSet<Integer> set) {
        if (!set.contains(currValue - 1)) return 1;

        Integer result = memo.getOrDefault(currValue, null);
        if (result != null) return result;

        Integer value = getLongestLengthRecursion(currValue - 1, memo, set) + 1;
        memo.put(currValue, value);
        return memo.get(currValue);
    }

    private static int getLongestSubsequenceLengthUsingPQ(int[] input) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int value : input) {
            queue.add(value);
        }
        Integer prev = queue.poll();
        int longest = -1;
        int count = 1;

        while (!queue.isEmpty()) {
            Integer next = queue.poll();

            if (next == prev + 1) {
                count += 1;
            } else {
                count = 1;
            }
            if (longest < count) {
                longest = count;
            }
            prev = next;
        }
        return longest;
    }
}
