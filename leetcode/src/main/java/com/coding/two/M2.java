package com.coding.two;

import com.coding.ListNode;

/**
 * 链表操作
 */
public class M2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode current = ans;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x1 = (l1 != null) ? l1.val : 0;
            int x2 = (l2 != null) ? l2.val : 0;
            int v = x1 + x2 + carry;
            ListNode node = new ListNode(v % 10);
            carry = v / 10;
            current.next = node;
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            current.next = node;
        }
        return ans.next;
    }
}
