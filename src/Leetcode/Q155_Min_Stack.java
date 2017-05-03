package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q155_Min_Stack {
    private Node head;

    /**
     * initialize your data structure here.
     */
    public Q155_Min_Stack() {

    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }

    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.data;
    }

    public int getMin() {
        return head.min;
    }
}

class Node {
    int data, min;
    Node next;

    Node(int data, int min, Node next) {
        this.data = data;
        this.min = min;
        this.next = next;
    }
}
