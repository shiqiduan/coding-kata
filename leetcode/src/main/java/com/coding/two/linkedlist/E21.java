package com.coding.two.linkedlist;

import com.coding.ListNode;

public class E21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代。 引入头结点
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode current = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = (l1 == null) ? l2 : l1;
        return newHead.next;
    }
}
