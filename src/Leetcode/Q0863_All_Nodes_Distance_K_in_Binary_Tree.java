package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * We are given a binary tree (with root node root), a target node, and an integer value k.
 *
 * Return a list of the values of all nodes that have a distance k from the target node.
 * The answer can be returned in any order.
 */

// https://www.youtube.com/watch?v=nPtARJ2cYrg
public class Q0863_All_Nodes_Distance_K_in_Binary_Tree {

    Map<TreeNode, TreeNode> parent = new HashMap();
    Set<TreeNode> seen = new HashSet();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        // Populate the parent HashMap
        dfs(root, null);

        Queue<TreeNode> queue = new LinkedList();
        queue.add(target);
        seen.add(target);

        int dist = 0;
        while (!queue.isEmpty()) {

            if (dist == K) {
                List<Integer> ans = new ArrayList();
                for (TreeNode n: queue)
                    ans.add(n.val);
                return ans;
            }

            dist++;
            int size = queue.size();
            for (int i=0; i < size; i++) {
                TreeNode curr = queue.remove();

                if (curr.left != null && !seen.contains(curr.left)) {
                    queue.add(curr.left);
                    seen.add(curr.left);
                }

                if (curr.right != null && !seen.contains(curr.right)) {
                    queue.add(curr.right);
                    seen.add(curr.right);
                }

                if (parent.containsKey(curr) && !seen.contains(parent.get(curr))) {
                    queue.add(parent.get(curr));
                    seen.add(parent.get(curr));
                }
            }
        }

        return new ArrayList<>();
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            if (par != null) parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
