package com.duan.leetcode;

public class M92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        ListNode leftNode = null;
        ListNode leftBefore = head;

        if (left == 1) {
            leftNode = head;
        } else {
            for (int i = 2; i < left; i++) {
                leftBefore = leftBefore.next;
            }
            leftNode = leftBefore.next;
        }

        ListNode a = leftNode, b = a.next, c = null;
        for (int i = left; i < right; i++) {
            c = b.next;
            b.next = a;

            a = b;
            b = c;
            if (b == null) {
                break;
            }
        }

        leftNode.next = b;

        if (left == 1) {
            return a;
        } else {
            leftBefore.next = a;
            return head;
        }
    }

    public static void main(String[] args) {
        M92 m = new M92();

        print(m.reverseBetween(build(new int[]{1, 2, 3, 4, 5}), 2, 4));
        print(m.reverseBetween(build(new int[]{1, 2, 3, 4, 5}), 1, 5));
        print(m.reverseBetween(build(new int[]{1, 2, 3, 4, 5}), 2, 5));
        print(m.reverseBetween(build(new int[]{1, 2, 3, 4, 5}), 1, 4));
        print(m.reverseBetween(build(new int[]{1, 2, 3, 4, 5}), 2, 2));
        print(m.reverseBetween(build(new int[]{5}), 1, 1));
    }

    private static ListNode build(int[] arr) {
        ListNode head = new ListNode();
        ListNode current = head;
        for (int i = 0; i < arr.length; i++) {
            ListNode a = new ListNode(arr[i]);
            current.next = a;
            current = current.next;
        }
        return head.next;
    }

    private static void print(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            sb.append("-");
            head = head.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
