package com.coding;

public class M61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int size = 1;
        ListNode current = head;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        ListNode tail = current;

        int t = k % size;
        if (t == 0) {
            return head;
        }
        t = size - t - 1;
        current = head;
        while (t > 0) {
            current = current.next;
            t--;
        }
        ListNode newHead = current.next;
        current.next = null;
        tail.next = head;
        return newHead;
    }
}
