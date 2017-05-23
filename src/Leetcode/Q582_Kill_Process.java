package Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by rbhatnagar2 on 5/23/17.
 */
public class Q582_Kill_Process {
    // DFS - TLE
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        // Store process tree as an adjacency list
        Map<Integer, List<Integer>> adjacencyLists = new HashMap<>();
        for (int i=0;i<ppid.size();i++) {
            adjacencyLists.putIfAbsent(ppid.get(i), new LinkedList<>());
            adjacencyLists.get(ppid.get(i)).add(pid.get(i));
        }

        // Kill all processes in the subtree rooted at process "kill"
        List<Integer> res = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(kill);
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            res.add(cur);
            List<Integer> adjacencyList = adjacencyLists.get(cur);
            if (adjacencyList == null) continue;
            stack.addAll(adjacencyList);
        }
        return res;

    }

    // Queue - Accepted
    public List<Integer> killProcessTwo(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); ++i) {
            map.putIfAbsent(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(kill);
        while (!q.isEmpty()) {
            int n = q.poll();
            ans.add(n);
            if (map.containsKey(n)) {
                q.addAll(map.get(n));
            }
        }
        return ans;
    }

    //Recursion
    public List<Integer> killProcessThree(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            map.putIfAbsent(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        List<Integer> res = new ArrayList<>();
        return killProcess(kill, res, map);
    }

    public List<Integer> killProcess(int kill, List<Integer> res, Map<Integer, List<Integer>> map) {
        res.add(kill);
        for (int pid : map.getOrDefault(kill, new ArrayList<>())) {
            killProcess(pid, res, map);
        }
        return res;
    }
}
