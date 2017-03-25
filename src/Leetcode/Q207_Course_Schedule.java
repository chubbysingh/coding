package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q207_Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return true;
        }

        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        // First transform the edge list to adj. list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : prerequisites) {
            if (adjList.containsKey(edge[0])) {
                List<Integer> neighbors = adjList.get(edge[0]);
                neighbors.add(edge[1]);
                adjList.put(edge[0], neighbors);
            } else {
                List<Integer> neighbors = new ArrayList<Integer>();
                neighbors.add(edge[1]);
                adjList.put(edge[0], neighbors);
            }
        }

        int[] visited = new int[numCourses];
        // Check if the graph contains a circle, if yes, return false.
        for (int i = 0; i < numCourses; i++) {
            if (hasCircles(i, visited, adjList)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCircles(int vertexId, int[] visited, Map<Integer, List<Integer>> adjList) {
        if (visited[vertexId] == -1) {
            return true;
        }

        if (visited[vertexId] == 1) {
            return false;
        }

        visited[vertexId] = -1;

        List<Integer> neighbors = adjList.get(vertexId);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (hasCircles(neighbor, visited, adjList)) {
                    return true;
                }
            }
        }

        visited[vertexId] = 1;

        return false;
    }
}
