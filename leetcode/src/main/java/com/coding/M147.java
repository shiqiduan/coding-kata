package com.coding;

public class M147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode current = head;
        while (current != null) {
            ListNode newCurrent = newHead;

            while (newCurrent.next != null && newCurrent.next.val < current.val) {
                newCurrent = newCurrent.next;
            }
            ListNode oldCurrent = current;
            current = current.next;

            oldCurrent.next = newCurrent.next;
            newCurrent.next = oldCurrent;
        }
        return newHead.next;
    }
}
