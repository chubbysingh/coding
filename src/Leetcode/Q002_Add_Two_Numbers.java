package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 */
public class Q002_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode head = result;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum = sum % 10;
            result.next = new ListNode(sum);
            result = result.next;
        }
        if (carry != 0) {
            result.next = new ListNode(carry);
        }
        return head.next;

    }

    // Recursive
    public ListNode addTwoNumbersRecursive(ListNode l1, ListNode l2) {
        return addTwoNumbersRecursive(l1, l2, 0);
    }

    private ListNode addTwoNumbersRecursive(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry == 1) {
                return new ListNode(1);
            } else {
                return null;
            }
        }

        int result = carry;
        result += l1 == null ? 0 : l1.data;
        result += l2 == null ? 0 : l2.data;

        carry = result / 10;
        result = result % 10;

        ListNode node = new ListNode(result);

        if (l1 == null) {
            node.next = addTwoNumbersRecursive(l1, l2.next, carry);
        } else if (l2 == null) {
            node.next = addTwoNumbersRecursive(l1.next, l2, carry);
        } else {
            node.next = addTwoNumbersRecursive(l1.next, l2.next, carry);
        }
        return node;
    }
}
