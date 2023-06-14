package com.coding.one;

import com.coding.ListNode;

public class H23 {

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int s, int e) {
        if (s == e) return lists[s];
        if (s > e) return null;
        if (s == (e - 1)) {
            return mergeTwo(lists[s], lists[e]);
        }
        int mid = s + (e - s) / 2;
        return mergeTwo(mergeKLists(lists, s, mid), mergeKLists(lists, mid + 1, e));
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode f = null;
        for (ListNode list : lists) {
            f = mergeTwo(f, list);
        }
        return f;
    }

    private ListNode mergeTwo(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }
            current = current.next;
        }
        current.next = (a == null) ? b : a;
        return head.next;
    }
}
