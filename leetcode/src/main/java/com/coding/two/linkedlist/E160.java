package com.coding.two.linkedlist;

import com.coding.ListNode;

public class E160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA, currB = headB;
        boolean oneA = false, oneB = false;
        while (currA != currB) {
            currA = currA.next;
            if (currA == null && !oneA) {
                currA = headB;
                oneA = true;
            }
            currB = currB.next;
            if (currB == null && !oneB) {
                currB = headA;
                oneB = true;
            }
        }
        return currA;
    }
}
