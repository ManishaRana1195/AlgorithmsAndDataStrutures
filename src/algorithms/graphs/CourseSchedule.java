package algorithms.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        if(prerequisites.length == 0){

        }

        List<Integer> adjacencyList[] = new ArrayList[numCourses];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        int lastIndex = 0;
        for (int[] pair : prerequisites) {
            int fromVertex = pair[0];
            int toVertex = pair[1];
            if(toVertex == fromVertex) continue;
            List<Integer> vertexNeighbours = adjacencyList[fromVertex];
            vertexNeighbours.add(toVertex);
            adjacencyList[fromVertex] = vertexNeighbours;
            lastIndex = fromVertex;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(lastIndex);
        boolean[] isVisited = new boolean[numCourses];
        List<Integer> result = new ArrayList<>();

        dfs(adjacencyList, stack, isVisited, result);
        int[] answer = new int[numCourses];

        int i=0;
        for (Integer val :result) {
            answer[i++] = val;
        }
    }

    private static void dfs(List<Integer>[] adjacencyList, Stack<Integer> stack, boolean[] isVisited, List<Integer> result) {
        while (!stack.isEmpty()) {
            Integer top = stack.pop();
            if (isVisited[top]) {
                continue;
            }
            isVisited[top] = true;
            List<Integer> neighbours = adjacencyList[top];
            for (Integer neighbor : neighbours) {
                if (!isVisited[neighbor]) {
                    stack.push(neighbor);
                    dfs(adjacencyList, stack, isVisited, result);
                }
            }
            result.add(top);

            
        }
    }

}
