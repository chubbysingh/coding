package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q103_Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean zigZag = true;

        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<Integer>();
            int size = queue.size();

            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();

                if (zigZag)
                    list.add(node.val);
                else
                    list.add(0, node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);

            }
            result.add(list);
            zigZag = !zigZag;
        }
        return result;
    }
}
