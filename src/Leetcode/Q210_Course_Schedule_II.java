package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q210_Course_Schedule_II {
    private int label;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }
        this.label = numCourses - 1;

        int[] result = new int[numCourses];

        // No prerequisites
        if (prerequisites == null || prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                result[i] = i;
            }

            return result;
        }

        // Convert the edge list to adj. list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : prerequisites) {
            if (!adjList.containsKey(edge[1])) {
                adjList.put(edge[1], new ArrayList<>());
            }
            adjList.get(edge[1]).add(edge[0]);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (toplogicalSorting(i, visited, adjList, result) == false) {
                return new int[0];
            }
        }

        return result;
    }

    private boolean toplogicalSorting(int vertexId, int[] visited,
                                      Map<Integer, List<Integer>> adjList,
                                      int[] result) {
        // Has been visited
        if (visited[vertexId] == -1) {
            return false;
        }

        // Has been added into the list
        if (visited[vertexId] == 1) {
            return true;
        }

        visited[vertexId] = -1;

        List<Integer> neighbors = adjList.get(vertexId);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (toplogicalSorting(neighbor, visited,
                        adjList, result) == false) {
                    return false;
                }
            }
        }

        result[label--] = vertexId;
        visited[vertexId] = 1;

        return true;
    }

    public static void main(String[] args) {
        Q210_Course_Schedule_II sol = new Q210_Course_Schedule_II();

        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        int[] result = sol.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(result));
    }
}
