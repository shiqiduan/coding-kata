package com.duan.leetcode;

public class E1290 {
    public int getDecimalValue(ListNode head) {
        if(head == null) {
            return 0;
        }
        int ret = 0;
        while(head != null) {
            ret = (ret << 1) + head.val;
            head = head.next;
        }
        return ret;
    }
}
