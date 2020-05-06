package algorithms.graphs;

import java.util.*;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        boolean[] isVisited = new boolean[adj.length];
        int componentCount = 0;

        for (int vertex = 0; vertex < adj.length; vertex++) {
            if (!isVisited[vertex]) {
                exploreVertex(vertex, isVisited, adj);
                componentCount += 1;
            }
        }

        return componentCount;
    }

    public static void exploreVertex(int vertex, boolean[] isVisited, ArrayList<Integer>[] adj) {
        isVisited[vertex] = true;
        ArrayList<Integer> adjacents = adj[vertex];
        for (Integer node : adjacents) {
            if (!isVisited[node]) {
                exploreVertex(node, isVisited, adj); // should be recursive
            }
        }
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
        System.out.println("Number of components:");
        System.out.println(numberOfComponents(adj));
    }

    /*Test with input
    * 4 4
    * 1 2
    * 3 2
    * 4 3
    * 1 4
    * Output: 1*/
}

