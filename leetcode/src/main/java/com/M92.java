package com;

import com.coding.ListNode;

public class M92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        int n = 0;
        ListNode beforeLeft = newHead;
        while (n < (left - 1)) {
            beforeLeft = beforeLeft.next;
            n++;
        }

        ListNode a = beforeLeft.next, b = a.next;
        n = left + 1;
        while (n <= right) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
            n++;
        }
        beforeLeft.next.next = b;
        beforeLeft.next = a;
        return newHead.next;
    }
}
