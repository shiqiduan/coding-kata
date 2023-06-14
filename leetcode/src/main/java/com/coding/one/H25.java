package com.coding.one;

import com.coding.ListNode;

public class H25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        if (count < k) {
            return head;
        }
        curr = reverseKGroup(curr, k);
        while (count != 0) {
            count--;
            ListNode temp = head.next;
            head.next = curr;
            curr = head;
            head = temp;
        }
        return curr;
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = newHead, curr = head;
        while (curr != null) {
            ListNode first = curr;
            for (int i = 1; i < k; i++) {
                curr = curr.next;
                if (curr == null) {
                    prev.next = first;
                    return newHead.next;
                }
            }
            ListNode nextTemp = curr.next;
            curr.next = null;
            prev.next = reverseList(first);
            prev = first;
            curr = nextTemp;
        }
        return newHead.next;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
