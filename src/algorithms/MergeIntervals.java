package algorithms;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] schedule = {{1, 3}, {2, 6}, {8, 10}, {15, 18}, {17, 20}};

        if (schedule.length == 0) return;
        List<Interval> input = getIntervals(schedule);
        sortInterval(input);
        merge(input);
        schedule = new int[][]{{0, 1}, {3, 5}, {4, 8}, {9, 10}, {10, 12}};
        input = getIntervals(schedule);
        sortInterval(input);
        merge(input);
    }

    private static List<Interval> getIntervals(int[][] schedule) {
        List<Interval> input = new ArrayList<>();
        for (int[] interval : schedule) {
            input.add(new Interval(interval[0], interval[1]));
        }
        return input;
    }

    private static void sortInterval(List<Interval> input) {
        Collections.sort(input, (o1, o2) -> {
            if (o1.start > o2.start) return 1;
            if (o1.start == o2.start) return 0;
            return -1;
        });
    }

    private static void merge(List<Interval> intervals) {
        LinkedList<Interval> result = new LinkedList<>();
        result.addLast(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval last = result.getLast();
            Interval current = intervals.get(i);

            if (last.end < current.start) {
                result.addLast(current);
            } else if (current.start <= last.end && last.end <= current.end) {
                result.removeLast();
                result.add(new Interval(last.start, current.end));
            }
        }
        System.out.println("The merged intervals: ");
        for (Interval interval : result) {
            System.out.println("[" + interval.start + "," + interval.end + "]");
        }
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}