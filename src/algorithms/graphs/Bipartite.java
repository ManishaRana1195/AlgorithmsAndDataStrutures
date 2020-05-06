package algorithms.graphs;

import java.util.*;

public class Bipartite {
    private static boolean bipartite(ArrayList<Integer>[] adj) {
        HashMap<Integer, Integer> colorMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        colorMap.put(1, 0);
        while (!queue.isEmpty()) {
            Integer frontNode = queue.remove();
            Integer parentColor = colorMap.get(frontNode);
            ArrayList<Integer> neighbors = adj[frontNode];
            for (Integer neighbor : neighbors) {
                Integer neighborColor = colorMap.getOrDefault(neighbor, null);
                if (neighborColor != null) {
                    if (Objects.equals(neighborColor, parentColor)) return false;
                } else {
                    colorMap.put(neighbor, 1 - parentColor);
                    queue.add(neighbor);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(bipartite(adj));
    }
}

