package com.coding;

public class M148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return mergeSort(head, count);
    }

    public ListNode mergeSort(ListNode head, int len) {
        len = len / 2 - 1;
        ListNode current = head;
        while (len > 0) {
            current = current.next;
            len--;
        }
        ListNode right = current.next;
        current.next = null;

        ListNode a = sortList(head);
        ListNode b = sortList(right);
        return merge(a, b);
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode ret = new ListNode(0), current = ret;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }
            current = current.next;
        }
        if (a == null) {
            current.next = b;
        } else {
            current.next = a;
        }
        return ret.next;
    }

    public static void main(String[] args) {
        M148 m = new M148();

        ListNode head = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        head.next = n2;
        n2.next = n1;
        n1.next = n3;

        printList(m.sortList(head));
    }

    private static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        System.out.println(sb.toString());
    }
}
