package com.duan.leetcode;

public class M61 {
    public ListNode rotateRight(final ListNode head, final int k) {
        if (head == null || k == 0) return head;

        int len = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            len++;
        }

        int rotateTimes = k % len;
        if (rotateTimes == 0) {
            return head;
        }

        int times = len - rotateTimes;
        current = head;
        while (times > 1) {
            current = current.next;
            times--;
        }

        ListNode newHead = current.next;
        current.next = null;

        ListNode tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        return newHead;
    }

    public static void main(final String[] args) {
        final M61 m = new M61();

        System.out.println(99 % 1);
    }
}