package com.coding;

public class M2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode ret = head;

        int add = 0;
        while (l1 != null || l2 != null || add > 0) {
            int val = ((l1 != null) ? l1.val : 0) + ((l2 != null) ? l2.val : 0) + add;
            if (val >= 10) {
                val = val - 10;
                add = 1;
            } else {
                add = 0;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            ret.next = new ListNode(val);
            ret = ret.next;
        }
        return head.next;
    }
}
