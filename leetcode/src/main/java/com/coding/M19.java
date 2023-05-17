package com.coding;

public class M19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        if (n == count) {
            return head.next;
        }
        count = count - n - 1;
        current = head;
        while (count > 0) {
            current = current.next;
            count--;
        }
        current.next = current.next.next;
        return head;
    }
}
