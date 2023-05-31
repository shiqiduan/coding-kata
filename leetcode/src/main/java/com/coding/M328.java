package com.coding;

public class M328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode a = head, b = head.next, bHead = head.next;

        while (b != null && b.next != null) {
            a.next = b.next;
            a = a.next;
            b.next = a.next;
            b = b.next;
        }
        a.next = bHead;
        return head;
    }
}
