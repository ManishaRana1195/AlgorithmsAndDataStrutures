package datastructures.graphs;

import java.util.LinkedList;

public class ShortestPathBFS {
    private static int nodesInNextLayer;

    public static void main(String[] args) {
        GraphMatrix graph = new GraphMatrix(7);
        graph.addEdge(0, 0);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 4);
        graph.addEdge(0, 5);
        graph.addEdge(0, 6);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 6);
        graph.addEdge(2, 0);
        graph.addEdge(2, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 0);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 1);
        graph.addEdge(4, 3);

        graph.addExit(4, 4);

        System.out.println("Number of steps to reach exit:");
        System.out.println(bfsForShortestPath(graph));
    }

    private static int bfsForShortestPath(GraphMatrix graph) {
        LinkedList<Pair> visitedNodes = new LinkedList<>();
        int vertices = graph.getNumberOfVertices();
        boolean[][] isVisited = new boolean[vertices][vertices];

        int nodesLeftInLayer = 1;
        int movesCount = 0;
        visitedNodes.push(new Pair(0, 0));
        isVisited[0][0] = true;

        while (!visitedNodes.isEmpty()) {
            Pair currentNode = visitedNodes.remove();
            int x = currentNode.x;
            int y = currentNode.y;
            System.out.println("x " + x + ", y " + y);

            if (graph.get(x, y) == 2) return movesCount;
            exploreVertex(graph, x, y, isVisited, visitedNodes);

            nodesLeftInLayer -= 1;
            if (nodesLeftInLayer == 0) {
                nodesLeftInLayer = nodesInNextLayer;
                nodesInNextLayer = 0;
                movesCount += 1;
            }

        }

        return -1;
    }

    private static void exploreVertex(GraphMatrix graph, int x, int y, boolean[][] isVisited, LinkedList<Pair> visitedNodes) {
        int numberOfVertices = graph.getNumberOfVertices();
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        for (int i = 0; i < dr.length; i++) {
            int newX = x + dr[i];
            int newY = y + dc[i];


            if (newX < 0 || newY < 0) continue;
            if (newX >= numberOfVertices || newY >= numberOfVertices) continue;

            if (isVisited[newX][newY]) continue;
            if (graph.get(newX, newY) == 0) continue;
            visitedNodes.push(new Pair(newX, newY));
            isVisited[x][y] = true;
            nodesInNextLayer += 1;
        }
    }

}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;

        Pair pair = (Pair) o;

        if (x != pair.x) return false;
        return y == pair.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
