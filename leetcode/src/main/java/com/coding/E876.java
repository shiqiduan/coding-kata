package com.coding;

public class E876 {
    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode current = head;
        while (current != null) {
            len++;
            current = current.next;
        }
        current = head;
        int t = 0;
        while (t < len / 2) {
            current = current.next;
            t++;
        }
        return current;
    }
}
