package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q234_Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        ListNode first = head;
        ListNode second = getMid(head);
        second = reverse(second);

        while(first != null && second != null) {
            if (first.data != second.data)
                return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }

    private ListNode getMid(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        return walker;
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
