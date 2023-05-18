package com.coding;

public class M24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode a = newHead;
        while (a != null && a.next != null && a.next.next != null) {
            ListNode b = a.next, c = b.next;
            b.next = c.next;
            c.next = b;
            a.next = c;
            a = a.next.next;
        }
        return newHead.next;
    }
}
