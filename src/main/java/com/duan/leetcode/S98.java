package com.duan.leetcode;

public class S98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE - 1L, Integer.MAX_VALUE + 1L);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if(root == null) return true;

        if(root.val > min && root.val < max) {
            return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
        }
        return false;
    }

    public static void main(String[] args) {
        S98 s = new S98();
        System.out.println(s.isValidBST(new TreeNode(2147483647)));
    }
}
