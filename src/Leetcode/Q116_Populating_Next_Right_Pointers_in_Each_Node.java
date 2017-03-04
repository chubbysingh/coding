package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q116_Populating_Next_Right_Pointers_in_Each_Node {

    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        if (root.left != null) {
            root.left.next = root.right;
        }

        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
    }


    public void connectIterative(TreeLinkNode root) {
        if (root == null)
            return;

        TreeLinkNode curr = root;

        while (curr != null && curr.left != null) {

            TreeLinkNode p = curr;
            while (p != null) {
                if (p.left != null)
                    p.left.next = p.right;
                if (p.right != null && p.next != null)
                    p.right.next = p.next.left;
                p = p.next;
            }
            curr = curr.left;
        }

    }

    class TreeLinkNode {
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
    }
}
