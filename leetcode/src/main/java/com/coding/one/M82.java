package com.coding.one;

import com.coding.ListNode;

public class M82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode a = newHead, b = newHead.next, c = b.next;

        while (c != null) {
            boolean found = false;
            while (c != null && b.val == c.val) {
                c = c.next;
                found = true;
            }
            if (found) {
                a.next = c;
            } else {
                a = b;
            }
            b = c;
            if (c != null) {
                c = c.next;
            }
        }
        return newHead.next;
    }
}
