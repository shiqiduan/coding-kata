package com.duan.leetcode;

public class S83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode current = head.next;
        ListNode prev = head;
        int lastVal = head.val;
        while (current != null) {
            if(lastVal == current.val) {
                // 删除当前元素
                current = current.next;
                prev.next = current;
            } else {
                lastVal = current.val;
                prev = current;
                current = current.next;
            }
        }
        return head;
    }
}
