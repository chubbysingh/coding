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

        int low = 0,
            high = lists.length - 1;

        return merge(lists, low, high);
    }

    ListNode merge(ListNode[] lists, int low, int high) {
        if (low == high)
            return lists[low];

        int mid = low + (high - low)/2;

        ListNode l1 = merge(lists, low, mid);
        ListNode l2 = merge(lists, mid + 1, high);

        return mergeTwoLists(l1, l2);
    }

    // 21. https://leetcode.com/problems/merge-two-sorted-lists/
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);
        ListNode resHead = res;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                resHead.next = l1;
                l1 = l1.next;
            } else {
                resHead.next = l2;
                l2 = l2.next;
            }
            resHead = resHead.next;
        }
        if (l1 != null) resHead.next = l1;

        if (l2 != null) resHead.next = l2;

        return res.next;
    }
}
