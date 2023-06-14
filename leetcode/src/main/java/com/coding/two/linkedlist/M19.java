package com.coding.two.linkedlist;

import com.coding.ListNode;

public class M19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点，处理边界条件
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode slow = newHead, fast = newHead;
        while (n >= 1) {
            fast = fast.next;
            n--;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }
}
