package com.coding;

public class M82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        boolean found = true;
        ListNode a = newHead, b = newHead.next, c = b.next;
        while (c != null) {
            found = false;
            while (c != null && b.val == c.val) {
                found = true;
                c = c.next;
            }
            if (found) {
                a.next = c;
            } else {
                a = a.next;
            }
            b = c;
            c = (c == null) ? null : c.next;
        }
        return newHead.next;
    }
}
