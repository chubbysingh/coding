package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q234_Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head,
                slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;

        while (slow != null && fast != null) {
            if (fast.data != slow.data)
                return false;
            else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
