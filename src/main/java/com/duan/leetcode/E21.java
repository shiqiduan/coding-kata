package com.duan.leetcode;

public class E21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode head;
        ListNode a = list1;
        ListNode b = list2;
        if(a.val <= b.val) {
            head = a;
        } else {
            head = b;
        }

        while (a != null && b != null) {
            if(a.val <= b.val) {
                ListNode temp = a.next;
                a.next = b;
                a = temp;
            } else {
                ListNode temp = b.next;
                b.next = a;
                b = temp;
            }
        }
        return head;
    }
}
