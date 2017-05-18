package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * <p>
 * Java Solution
 * <p>
 * For each node, its left child's degree is -1 and is right child's degree is +1.
 * We can do a level order traversal and save the degree information.
 */

public class Q314_Binary_Tree_Vertical_Order_Traversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;

        // level and list
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> level = new LinkedList<Integer>();

        queue.offer(root);
        level.offer(0);

        int minLevel = 0;
        int maxLevel = 0;

        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            int l = level.poll();

            //track min and max levels
            minLevel = Math.min(minLevel, l);
            maxLevel = Math.max(maxLevel, l);

            if (!map.containsKey(l)) {
                List<Integer> list = new ArrayList<Integer>();
                map.put(l, list);
            }
            map.get(l).add(p.val);

            if (p.left != null) {
                queue.offer(p.left);
                level.offer(l - 1);
            }

            if (p.right != null) {
                queue.offer(p.right);
                level.offer(l + 1);
            }
        }


        for (int i = minLevel; i <= maxLevel; i++) {
            if (map.containsKey(i)) {
                result.add(map.get(i));
            }
        }

        return result;
    }
}
