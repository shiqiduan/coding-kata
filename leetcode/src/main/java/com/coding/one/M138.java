package com.coding.one;

import java.util.HashMap;
import java.util.Map;

public class M138 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node newHead = null, newTail = null, current = head;
        Map<Node, Node> map = new HashMap<>();
        while (current != null) {
            Node node = new Node(current.val);
            if (newTail == null) {
                newTail = node;
                newHead = node;
            } else {
                newTail.next = node;
                newTail = newTail.next;
            }
            map.put(current, node);
            current = current.next;
        }
        current = head;
        Node newCurrent = newHead;
        while (current != null) {
            if (current.random != null) {
                newCurrent.random = map.get(current.random);
            }
            newCurrent = newCurrent.next;
            current = current.next;
        }
        return newHead;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
