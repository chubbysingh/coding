package com.whitespace.raghav.LinkedList;

/**
 * Created by rbhatnagar2 on 12/14/15.
 */
public class DetectAndRemoveLoop {
    public int detectAndRemoveLoop(Node head) {
        Node slow = head, fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                //Loop found. Remove the loop
                return 1;
            }
        }
        return 0;
    }

    private void removeLoop (Node loopNode, Node head) {
        //Get the size of the loop
        Node tmp1 = loopNode, tmp2 = loopNode;

        int sizeOfLoop = 1;
        while(tmp1.next != tmp2) {
            sizeOfLoop++;
            tmp1 = tmp1.next;
        }

        //Fix one pointer to head
        tmp1 = head;

        //Fix second pointer to sizeOfLoop node after head
        tmp2 = head;
        for (int i = 0; i < sizeOfLoop; i++) {
            tmp2 = tmp2.next;
        }

        //Move both pointers one step at a time.
        // They will meet at the start of the loop
        while (tmp1 != tmp2) {
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }

        //Get the end of the loop
        while (tmp2.next != tmp1) {
            tmp2 = tmp2.next;
        }

        //Remove the link
        tmp2.next = null;

    }
}
