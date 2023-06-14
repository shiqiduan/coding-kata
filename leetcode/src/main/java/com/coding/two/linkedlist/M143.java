package com.coding.two.linkedlist;

import com.coding.ListNode;

public class M143 {
    public void reorderList(ListNode head) {
        reorder(head);
    }

    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        while (curr.next != null && curr.next.next != null) {
            curr = curr.next;
        }
        ListNode last = curr.next;
        curr.next = null;
        last.next = reorder(head.next);
        head.next = last;
        return head;
    }
}
