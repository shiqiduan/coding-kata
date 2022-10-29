package com.duan.leetcode;

public class S876 {
    public ListNode middleNode(ListNode head) {
        ListNode s = head, e = head;
        while (e != null) {
            e = e.next;
            if(e != null) {
                e = e.next;
                s = s.next;
            } else {
                return s;
            }
        }
        return s;
    }
}
