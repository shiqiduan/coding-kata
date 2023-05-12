package com.coding;

public class E203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode current = newHead;
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
                continue;
            }
            current = current.next;
        }
        return newHead.next;
    }
}
