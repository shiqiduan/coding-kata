package com.duan.leetcode;

public class E606 {
    public String tree2str(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        track(root, sb);
        return sb.toString();
    }

    private void track(TreeNode node, StringBuffer sb) {
        sb.append(node.val);
        if (node.left == null && node.right != null) {
            sb.append("()");
            sb.append("(");
            track(node.right, sb);
            sb.append(")");
        } else {
            if (node.left != null) {
                sb.append("(");
                track(node.left, sb);
                sb.append(")");
            }
            if (node.right != null) {
                sb.append("(");
                track(node.right, sb);
                sb.append(")");
            }
        }
    }
}
