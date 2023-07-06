package com.coding.one;

import com.coding.ListNode;

import java.util.Stack;

public class M2487 {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            while (!stack.isEmpty() && current.val > stack.peek().val) {
                stack.pop();
            }
            stack.push(current);
            current = current.next;
        }
        head = null;
        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            pop.next = head;
            head = pop;
        }
        return head;
    }
}
