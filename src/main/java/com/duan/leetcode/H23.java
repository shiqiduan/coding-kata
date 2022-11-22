package com.duan.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class H23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            if(list != null) {
                pq.add(lists[i]);
            }
        }
        ListNode ret = new ListNode();
        ListNode current = ret;
        while (!pq.isEmpty()) {
            current.next = pq.poll();
            current = current.next;
            if(current.next != null) {
                pq.add(current.next);
            }
        }
        return ret.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode head = null;
        for (int i = 0; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode current = head;

        while (list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if(list1 != null) {
            current.next = list1;
        }
        if(list2 != null) {
            current.next = list2;
        }
        return head.next;
    }
}
