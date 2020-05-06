package algorithms.graphs;

import java.util.*;

public class Acyclicity {
    private static int acyclic(ArrayList<Integer>[] adj) {
        Stack<Integer> unvisited = new Stack<>();
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for (ArrayList<Integer> nodes : adj) {
            for (Integer node : nodes) {
                if (!unvisited.contains(node)) {
                    unvisited.add(node);
                }
            }
        }
        unvisited.push(0);
        /*assuming all nodes are strongly connected*/
        boolean hasCycle = performDFS(adj, unvisited, visiting, visited);
        System.out.println(hasCycle);
        return 0;
    }

    private static boolean performDFS(ArrayList<Integer>[] adj, Stack<Integer> unvisited, Set<Integer> visiting, Set<Integer> visited) {
        while (!unvisited.isEmpty()) {
            Integer top = unvisited.pop();
            visiting.add(top);
            ArrayList<Integer> neighbors = adj[top];

            for (Integer neighbor : neighbors) {
                if (visiting.contains(neighbor)) {
                    return true;
                }
                unvisited.push(neighbor);
                performDFS(adj, unvisited, visiting, visited);
            }
            visiting.remove(top);
            visited.add(top);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(acyclic(adj));
    }
}

