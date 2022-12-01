package com.duan.leetcode;

import com.google.common.collect.Lists;

import java.util.List;

public class M24 {
    public ListNode swapPairs(ListNode head) {
        ListNode a = head;
        head = new ListNode();
        ListNode last = head;
        last.next = a;

        while (a != null && a.next != null) {
            ListNode b = a.next;
            a.next = b.next;
            b.next = a;
            last.next = b;

            last = a;
            a = a.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        M24 m = new M24();

        ListNode head = null;
        printResult(head, m);

        printResult(getList(Lists.newArrayList(1,2,3,4)), m);
        printResult(getList(Lists.newArrayList(1)), m);
        printResult(getList(Lists.newArrayList(1, 2)), m);
        printResult(getList(Lists.newArrayList(1, 2, 3)), m);
        printResult(getList(Lists.newArrayList(1, 2, 3, 4, 5)), m);
    }

    private static ListNode getList(List<Integer> list) {
        ListNode head = new ListNode();
        ListNode current = head;
        for (Integer x : list) {
            ListNode node = new ListNode(x);
            current.next = node;
            current = current.next;
        }
        return head.next;
    }

    private static void printResult(ListNode head, M24 m) {
        ListNode listNode = m.swapPairs(head);

        if(listNode == null) {
            System.out.println("empty");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (listNode != null) {
            sb.append(listNode.val);
            sb.append("->");
            listNode = listNode.next;
        }
        System.out.println(sb.toString());
    }
}
