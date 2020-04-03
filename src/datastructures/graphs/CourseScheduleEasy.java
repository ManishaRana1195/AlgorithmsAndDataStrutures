package datastructures.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class CourseScheduleEasy {
    /*dfs takes consume lot of time for large inputs, so you try bfs.*/
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};

        // handle edge cases
        List<Integer>[] adjacencyList = (ArrayList<Integer>[]) new ArrayList[numCourses];

        if (prerequisites.length == 0) return; // true
        for (int i = 0; i < numCourses; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int[] nodePair : prerequisites) {
            adjacencyList[nodePair[0]].add(nodePair[1]);
        }

        // check if strongly connected graph or not
        Stack<Integer> unvisited = new Stack<>();
        HashSet<Integer> visiting = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        unvisited.push(0);

        boolean hasCycle = checkIfCourseCanComplete(adjacencyList, unvisited, visiting, visited);

        System.out.println("Can courses be completed: " + hasCycle);
    }

    private static boolean checkIfCourseCanComplete(List<Integer>[] adjacencyList, Stack<Integer> unvisited, HashSet<Integer> visiting, HashSet<Integer> visited) {
        while (!unvisited.isEmpty()) {
            Integer top = unvisited.pop();
            visiting.add(top);
            List<Integer> neighbours = adjacencyList[top];
            for (Integer neighbor : neighbours) {
                if (visiting.contains(neighbor)) {
                    return false;
                }
                unvisited.push(neighbor);
                checkIfCourseCanComplete(adjacencyList, unvisited, visiting, visited);
            }
            visiting.remove(top);
            visited.add(top);
        }
        return true;
    }
}
