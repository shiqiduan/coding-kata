package com.coding;

public class E141 {
    public boolean hasCycle(ListNode head) {
        ListNode one = head, two = head;
        while (two != null && two.next != null && two.next.next != null) {
            two = two.next.next;
            one = one.next;
            if (one == two) {
                return true;
            }
        }
        return false;
    }
}
