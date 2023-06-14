package com.coding.two.linkedlist;

import com.coding.ListNode;

public class M86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode lowHead = new ListNode(0);
        ListNode gtHead = new ListNode(0);
        ListNode current = head, l = lowHead, h = gtHead;
        while (current != null) {
            int v = current.val;
            if (current.val < x) {
                l.next = current;
                l = l.next;
            } else {
                h.next = current;
                h = h.next;
            }
            current = current.next;
        }
        l.next = gtHead.next;
        return lowHead.next;
    }
}
