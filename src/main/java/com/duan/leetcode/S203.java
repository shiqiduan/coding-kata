package com.duan.leetcode;

public class S203 {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if(head == null || head.next == null) return head;
        ListNode prev = head, current = head.next;

        while (current != null) {
            if(current.val == val) {
                current = current.next;
                prev.next = current;
            } else {
                current = current.next;
                prev = prev.next;
            }
        }
        return head;
    }
}
