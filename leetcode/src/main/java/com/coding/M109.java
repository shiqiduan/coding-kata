package com.coding;

public class M109 {
    public TreeNode sortedListToBST(ListNode head) {
        int len = getLen(head);
        return sortedListToBST(head, len);
    }

    private TreeNode sortedListToBST(ListNode head, int len) {
        if (len == 0) return null;
        if (len == 1) {
            return new TreeNode(head.val);
        }
        if (len == 2) {
            TreeNode p = new TreeNode(head.val);
            p.right = new TreeNode(head.next.val);
            return p;
        }

        int step = len / 2 - 1;

        ListNode curr = head;
        while (step > 0) {
            step--;
            curr = curr.next;
        }
        TreeNode p = new TreeNode(curr.next.val);
        p.right = sortedListToBST(curr.next.next, len - len / 2 - 1);
        curr.next = null;
        p.left = sortedListToBST(head, len / 2);
        return p;
    }


    private int getLen(ListNode head) {
        if (head == null) return 0;
        ListNode curr = head;
        int ans = 0;
        while (curr != null) {
            curr = curr.next;
            ans++;
        }
        return ans;
    }
}
