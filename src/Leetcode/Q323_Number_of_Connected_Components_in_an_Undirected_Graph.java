package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges
 * (each edge is a pair of nodes),
 * write a function to find the number of connected components in an undirected graph.
 * <p>
 * Example 1:
 * 0 3
 * | |
 * 1 --- 2 4
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 */
public class Q323_Number_of_Connected_Components_in_an_Undirected_Graph {
    //DFS
    public int countComponents(int n, int[][] edges) {
        if (n <= 0 || edges == null) {
            return 0;
        }

        if (n == 1 && edges.length == 0) {
            return 1;
        }

        int result = 0;
        boolean[] visited = new boolean[n];

        // step 1: create the adj list from edge list
        List[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            adjList[from].add(to);
            adjList[to].add(from);
        }

        // step 2: calculate the number of cc
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result++;
                countCCHelper(i, adjList, visited);
            }
        }

        return result;
    }

    private void countCCHelper(int node, List[] adjList, boolean[] visited) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;

        List<Integer> neighbors = adjList[node];

        for (int neighbor : neighbors) {
            countCCHelper(neighbor, adjList, visited);
        }
    }

    // Union find
    public int countComponentsTwo(int n, int[][] edges) {
        int count = n;

        int[] root = new int[n];
        // initialize each node is an island
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            int xRoot = getRoot(root, x);
            int yRoot = getRoot(root, y);

            if (xRoot != yRoot) {
                count--;
                root[xRoot] = yRoot;
            }

        }

        return count;
    }

    public int getRoot(int[] arr, int i) {
        while (arr[i] != i) {
            arr[i] = arr[arr[i]];
            i = arr[i];
        }
        return i;
    }
}
