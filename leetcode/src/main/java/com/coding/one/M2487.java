package com.coding.one;

import com.coding.ListNode;

public class M2487 {
    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = removeNodes(head.next);
        if (node.val > head.val) {
            return node;
        }
        head.next = node;
        return head;
    }
}
