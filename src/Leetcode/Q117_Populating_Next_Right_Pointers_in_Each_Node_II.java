package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q117_Populating_Next_Right_Pointers_in_Each_Node_II {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode curr = root;
        TreeLinkNode dummyNode = new TreeLinkNode(0);
        TreeLinkNode pre = dummyNode;

        while (curr != null) {
            TreeLinkNode p = curr;
            while (p != null) {
                if (p.left != null) {
                    pre.next = p.left;
                    pre = pre.next;
                }

                if (p.right != null) {
                    pre.next = p.right;
                    pre = pre.next;
                }

                p = p.next;

                if (p == null) {
                    curr = dummyNode.next;
                    pre = dummyNode;
                    dummyNode.next = null;
                }
            }
        }

    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}
