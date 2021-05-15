package Leetcode;

import Leetcode.Util.ListNode;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 * Input: 1->2
 * Output: false
 *
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 */
public class Q234_Palindrome_Linked_List {

    // O(n) time and O(n) space
    public boolean isPalindrome2(ListNode head) {
        //find half
        ListNode fast = head;
        ListNode slow = head;

        Stack<ListNode> stack = new Stack<>();

        while(fast != null && fast.next != null){

            stack.push(slow);

            fast = fast.next.next;
            slow=slow.next;
        }

        //if odd length, move one forward away from middle element
        if(fast!=null)
            slow = slow.next;

        //compare second half of the list to stack
        while(slow!=null){
            if(stack.pop().data != slow.data)
                return false;
            slow = slow.next;
        }
        return true;
    }

    // O(n) time and O(1) space
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
