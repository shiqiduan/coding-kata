package com.coding.two.linkedlist;

import com.coding.ListNode;

public class M24 {

    public ListNode swapPairs(ListNode head) {
        // 终止条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headNext = head.next;
        // 递归调用
        head.next = swapPairs(headNext.next);
        headNext.next = head;
        return headNext;
    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode a = newHead;
        while (a != null && a.next != null && a.next.next != null) {
            ListNode b = a.next, c = b.next;
            b.next = c.next;
            c.next = b;
            a.next = c;
            a = a.next.next;
        }
        return newHead.next;
    }
}
