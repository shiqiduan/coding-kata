package com.coding;

public class E1290 {
    public int getDecimalValue(ListNode head) {
        ListNode curr = head;
        int ret = 0;
        while (curr != null) {
            ret = (ret << 1) + curr.val;
            curr = curr.next;
        }
        return ret;
    }
}
