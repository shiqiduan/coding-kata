package com.coding;

public class M143 {
    public void reorderList(ListNode head) {
        reorder(head);
    }

    private ListNode reorder(ListNode head) {
        ListNode current = head, last = current;

        while (last.next != null && last.next.next != null) {
            last = last.next;
        }
        if (current == last) return head;

        ListNode temp = current.next;
        current.next = last.next;
        last.next = null;
        current.next.next = reorder(temp);
        return head;
    }
}
