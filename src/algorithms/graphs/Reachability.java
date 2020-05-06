package algorithms.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        boolean[] isVisited = new boolean[adj.length];
        ArrayList<Integer> adjacentNodes = adj[x];
        Queue<Integer> queue = new LinkedList<>();
        isVisited[x] = true;
        queue.addAll(adjacentNodes);
        while (!queue.isEmpty()) {
            Integer vertex = queue.remove();
            if (!isVisited[vertex]) {
                isVisited[vertex] = true;
                ArrayList<Integer> nodes = adj[vertex];
                queue.addAll(nodes);
            }

            if (vertex == y) {
                return 1;
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        System.out.println("Enter number of nodes and edges:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        System.out.println("Enter the start and end vertices.");
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;

        System.out.println("Is the vertex " + y + " reachable from vertex " + x + ":");
        System.out.println(reach(adj, x, y));
    }
}

