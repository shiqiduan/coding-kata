package com.coding;

public class E83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
                continue;
            }
            current = current.next;
        }
        return head;
    }
}
