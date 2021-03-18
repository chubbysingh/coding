package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 * <p>
 * Merge k sorted linked lists
 * and return it as one sorted list. Analyze and describe its complexity.
 */
public class Q0023_Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        if (lists.length == 1)
            return lists[0];

        int numLists = lists.length;

        return merge(lists, 0, numLists - 1);
    }

    ListNode merge(ListNode[] lists, int lo, int hi) {
        if (lo == hi)
            return lists[lo];

        int mid = (lo + hi) / 2;

        ListNode l1 = merge(lists, lo, mid);
        ListNode l2 = merge(lists, mid + 1, hi);

        return mergeTwoLists(l1, l2);
    }

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode p = head;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) p.next = l1;
        else if (l2 != null) p.next = l2;

        return head.next;
    }
}
