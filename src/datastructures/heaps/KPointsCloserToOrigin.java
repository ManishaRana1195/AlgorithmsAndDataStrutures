package datastructures.heaps;

import java.util.PriorityQueue;

public class KPointsCloserToOrigin {

    public static void main(String[] args) {
        int[][] points = new int[3][3];
        int K = 0;
        java.util.PriorityQueue<Distance> pq = new PriorityQueue<>((o1, o2) -> (int) (o2.dist - o1.dist));

        int minLength = Math.min(points.length, K);

        for (int i = 0; i < minLength; i++) {
            pq.add(new Distance(points[i][0], points[i][1]));
        }

        for (int i = minLength + 1; i < K; i++) {
            int x = points[i][0];
            int y = points[i][1];
            double currRoot = Math.sqrt(x * x + y * y);
            if (currRoot < pq.peek().dist) {
                pq.poll();
                pq.add(new Distance(x, y));
            }
        }

        int[][] result = new int[K][2];

        int i = 0;
        while (pq.size() > 0) {
            int index = i++;
            Distance dist = pq.poll();
            result[index][0] = dist.x;
            result[index][1] = dist.y;
        }

    }


}

class Distance {

    int x;
    int y;
    double dist;

    public Distance(int x, int y) {
        this.x = x;
        this.y = y;
        dist = Math.sqrt(x * x + y * y);
    }
}
