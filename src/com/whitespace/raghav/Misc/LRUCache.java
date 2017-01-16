package com.whitespace.raghav.Misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 12/7/15.
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head;
    private Node end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;

        }
        return -1;
    }

    private void remove(Node n) {
        //Remove from the LinkedList
        if (n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }

        if (n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }
    }

    private void setHead(Node n) {
        // Set the node to head of LinkedList
        n.next = head;
        n.pre = null;

        if (head != null) {
            head.pre = n;
        }

        head = n;

        if (end == null) {
            end = head;
        }

    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node old  = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node created = new Node(key, value);
            if (map.size() > capacity) {
                map.remove(end.key);
                remove(end);
            }
            setHead(created);
        }
    }
}

class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node (int key, int value) {
        this.key = key;
        this.value = value;
    }
}
