package com.coding.easytwo;

import com.coding.ListNode;

/**
 * 链表操作
 */
public class E83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode a = head, b = head.next;
        while (b != null) {
            if (b.val == a.val) {
                a.next = b.next;
            } else {
                a = b;
            }
            b = b.next;
        }
        return head;
    }
}
