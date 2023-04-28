package com.coding;

public class E206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode a = head, b = head.next;
        a.next = null;
        while (b != null) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        return a;
    }
}
