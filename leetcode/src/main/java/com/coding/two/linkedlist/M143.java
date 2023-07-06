package com.coding.two.linkedlist;

import com.coding.ListNode;

import java.util.Stack;

public class M143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        current = head;
        ListNode next = current.next;
        while (current != stack.peek() && next != stack.peek()) {
            ListNode pop = stack.pop();
            current.next = pop;
            pop.next = next;
            current = next;
            next = next.next;
        }
        if (stack.peek() == next) {
            next.next = null;
        }
        if (stack.peek() == current) {
            current.next = null;
        }
    }
}
