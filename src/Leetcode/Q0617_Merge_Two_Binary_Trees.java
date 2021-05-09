package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Return the merged tree.
 */
public class Q0617_Merge_Two_Binary_Trees {
    public TreeNode mergeTreesRecursive(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;

        root1.left = mergeTreesRecursive(root1.left, root2.left);
        root1.right = mergeTreesRecursive(root1.right, root2.right);

        return root1;
    }

    public TreeNode mergeTreesIterative(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }

        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[] {root1, root2});

        while (!queue.isEmpty()) {
            TreeNode[] cur = queue.poll();
            // no need to merge t2 into t1
            if (cur[1] == null) {
                continue;
            }
            // merge t1 and t2
            cur[0].val += cur[1].val;
            // if node in t1 == null, use node in t2 instead
            // else put both nodes in stack to merge
            if (cur[0].left == null) {
                cur[0].left = cur[1].left;
            } else {
                queue.offer(new TreeNode[] {cur[0].left, cur[1].left});
            }
            if (cur[0].right == null) {
                cur[0].right = cur[1].right;
            } else {
                queue.offer(new TreeNode[] {cur[0].right, cur[1].right});
            }
        }
        return root1;
    }
}
