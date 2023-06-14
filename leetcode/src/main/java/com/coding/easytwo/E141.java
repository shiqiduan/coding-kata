package com.coding.easytwo;

import com.coding.ListNode;

import java.util.HashSet;
import java.util.Set;

public class E141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        ListNode curr = head;
        Set<ListNode> set = new HashSet<>();
        while (curr != null) {
            if (set.contains(curr)) {
                return true;
            }
            set.add(curr);
            curr = curr.next;
        }
        return false;
    }
}
