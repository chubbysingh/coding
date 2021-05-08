package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree,
 * return the average value of the nodes on each level in the form of an array.
 */
public class Q0637_Average_of_Levels_in_Binary_Tree {
    public List< Double > averageOfLevels(TreeNode root) {

        List <Double> res = new ArrayList<>();

        Queue< TreeNode > queue = new LinkedList< >();
        queue.add(root);

        while (!queue.isEmpty()) {
            double levelSum = 0;
            int size = queue.size();

            for (int i=0; i < size; i++) {
                TreeNode curr = queue.remove();
                levelSum += curr.val;

                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            res.add(levelSum / size);
        }
        return res;
    }
}
