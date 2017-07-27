package Leetcode;

import Leetcode.Util.ListNode;
import Leetcode.Util.TreeNode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q109_Convert_Sorted_List_to_Binary_Search_Tree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        return toBST(head, null);
    }
    private TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail)
            return null;

        ListNode mid = getMid(head, tail);
        TreeNode root = new TreeNode(mid.data);
        root.left = toBST(head, mid);
        root.right = toBST(mid.next, tail);
        return root;
    }

    private ListNode getMid(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
