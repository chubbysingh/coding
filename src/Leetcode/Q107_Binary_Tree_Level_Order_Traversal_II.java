package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q107_Binary_Tree_Level_Order_Traversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (root == null)
            return result;


        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> list = new LinkedList<Integer>();
            int sizeOfQueue = queue.size();

            for (int i=0; i<sizeOfQueue; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);

            }
            result.add(list);

        }
        return reverse(result);
    }

    private List<List<Integer>> reverse(List<List<Integer>> res) {
        List<List<Integer>> reverse = new LinkedList<List<Integer>>();

        Stack<List<Integer>> stack = new Stack<List<Integer>>();

        for (List<Integer> list : res) {
            stack.push(list);
        }

        while (!stack.isEmpty()) {
            reverse.add(stack.pop());
        }
        return reverse;
    }
}
