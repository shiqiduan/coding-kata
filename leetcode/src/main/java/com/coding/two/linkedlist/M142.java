package com.coding.two.linkedlist;

import com.coding.ListNode;

import java.util.HashSet;
import java.util.Set;

public class M142 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head, prev = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }
        if (!cycle) return null;
        while (slow != prev) {
            slow = slow.next;
            prev = prev.next;
        }
        return prev;
    }

    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (set.contains(curr)) {
                return curr;
            }
            set.add(curr);
            curr = curr.next;
        }
        return null;
    }
}
