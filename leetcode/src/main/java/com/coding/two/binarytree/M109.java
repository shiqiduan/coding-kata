package com.coding.two.binarytree;

import com.coding.ListNode;
import com.coding.TreeNode;

public class M109 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        int len = getLen(head);

        ListNode curr = head;
        int i = 0;
        while (i < (len / 2 - 1)) {
            curr = curr.next;
            i++;
        }
        TreeNode root = new TreeNode(curr.next.val);
        root.right = sortedListToBST(curr.next.next);
        curr.next = null;
        root.left = sortedListToBST(head);
        return root;
    }

    private int getLen(ListNode head) {
        int ans = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            ans++;
        }
        return ans;
    }
}
