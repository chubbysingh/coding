package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by rbhatnagar2 on 3/15/17.
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges
 * (each edge is a pair of nodes), check if these edges form a valid tree.

 Analysis

 This problem can be converted to finding a cycle in a graph.
 It can be solved by using DFS (Recursion) or BFS (Queue).

 */
public class Q261_Graph_Valid_Tree {

    // DFS
    public boolean validTreeDFS(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0; i<n; i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            map.put(i, list);
        }

        for(int[] edge: edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        if(!helper(0, -1, map, visited))
            return false;

        for(boolean b: visited){
            if(!b)
                return false;
        }

        return true;
    }

    public boolean helper(int curr, int parent, HashMap<Integer, ArrayList<Integer>> map, boolean[] visited){
        if(visited[curr])
            return false;

        visited[curr] = true;

        for(int i: map.get(curr)){
            if(i!=parent && !helper(i, curr, map, visited)){
                return false;
            }
        }

        return true;
    }

    // BFS
    public boolean validTreeBFS(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0; i<n; i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            map.put(i, list);
        }

        for(int[] edge: edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int top = queue.poll();
            if(visited[top])
                return false;

            visited[top]=true;

            for(int i: map.get(top)){
                if(!visited[i])
                    queue.offer(i);
            }
        }

        for(boolean b: visited){
            if(!b)
                return false;
        }

        return true;
    }
}
