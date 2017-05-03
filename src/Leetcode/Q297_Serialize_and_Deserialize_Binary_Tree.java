package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q297_Serialize_and_Deserialize_Binary_Tree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null)
            return sb.toString();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node != null) {
                sb.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("#" + ",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        String[] sArr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(sArr[0]));
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null)
                continue;
            if (i < sArr.length) {
                if (sArr[i].equals("#")) {
                    node.left = null;
                } else {
                    node.left = new TreeNode(Integer.parseInt(sArr[i]));
                }
                queue.add(node.left);
                i++;
            }

            if (i < sArr.length) {
                if (sArr[i].equals("#")) {
                    node.right = null;
                } else {
                    node.right = new TreeNode(Integer.parseInt(sArr[i]));
                }
                queue.add(node.right);
                i++;
            }
        }
        return root;
    }
}
