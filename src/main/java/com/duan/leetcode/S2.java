package com.duan.leetcode;

public class S2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode temp = ret;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;
            int val = v1 + v2 + carry;
            if(val >= 10) {
                val = val - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            temp.next = new ListNode(val, null);
            temp = temp.next;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        // 极端场景.
        if (carry > 0) {
            temp.next = new ListNode(carry, null);
        }
        return ret.next;
    }
}
