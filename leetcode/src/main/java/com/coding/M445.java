package com.coding;

public class M445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = reverse(l1);
        ListNode b = reverse(l2);
        int carry = 0;
        ListNode r = new ListNode(0);
        ListNode c = r;
        while (a != null || b != null) {
            int av = (a != null) ? a.val : 0;
            int bv = (b != null) ? b.val : 0;
            int cv = av + bv + carry;
            ListNode t = new ListNode(cv % 10);
            carry = cv / 10;
            c.next = t;

            c = c.next;
            if (a != null) {
                a = a.next;
            }
            if (b != null) {
                b = b.next;
            }
        }
        if (carry > 0) {
            ListNode t = new ListNode(carry);
            c.next = t;
        }
        return reverse(r.next);
    }

    private ListNode reverse(ListNode l) {
        if (l == null) return l;
        ListNode a = null, b = l;
        while (b != null) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        return a;
    }
}
