package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q138_Copy_List_with_Random_Pointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode curr = head;
        RandomListNode next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (curr != null) {
            next = curr.next;

            RandomListNode copy = new RandomListNode(curr.label);
            curr.next = copy;
            copy.next = next;

            curr = next;
        }

        // Second round: assign random pointers for the copy nodes.
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        curr = head;
        RandomListNode pseudoHead = new RandomListNode(0);
        RandomListNode copy, copyIter = pseudoHead;

        while (curr != null) {
            next = curr.next.next;

            // extract the copy
            copy = curr.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            curr.next = next;

            curr = next;
        }

        return pseudoHead.next;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    ;
}
