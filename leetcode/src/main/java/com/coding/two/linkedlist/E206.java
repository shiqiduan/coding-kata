package com.coding.two.linkedlist;

import com.coding.ListNode;

public class E206 {
    /**
     * 生涩
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        // 理解这里的指针变化，head.next.next 目前没有变化
        ListNode ret = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode a = head, b = head.next;
        // 遗漏条件
        a.next = null;
        while (b != null) {
            ListNode c = b.next;
            // 操作指针
            b.next = a;
            a = b;
            b = c;
        }
        return a;
    }
}
