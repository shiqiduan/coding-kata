package com.coding;

public class E234 {
    /**
     * 通过快慢指针找到中间位置，反转链表，然后比较
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return false;
        ListNode mid = findMid(head);
        ListNode end = reverse(mid);
        ListNode a = head, b = end;
        while (a != null && b != null) {
            if (a.val != b.val) return false;
            a = a.next;
            b = b.next;
        }
        return true;
    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode a = head, b = head.next;
        a.next = null;
        while (b != null) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        return a;
    }
}
