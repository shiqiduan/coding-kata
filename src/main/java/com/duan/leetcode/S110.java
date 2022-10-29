package com.duan.leetcode;

public class S110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int[] balanceRet = getBalanceRet(root);
        return balanceRet[0] == 1;
    }

    private int[] getBalanceRet(TreeNode node) {
        if(node == null) {
            return new int[]{1, 0};
        }
        int[] balanceRetLeft = getBalanceRet(node.left);
        int[] balanceRetRight = getBalanceRet(node.right);

        int balanced = balanceRetLeft[0] & balanceRetRight[0];
        if(Math.abs(balanceRetLeft[1] - balanceRetRight[1]) > 1) {
            balanced = 0;
        }
        return new int[] {balanced, Math.max(balanceRetLeft[1], balanceRetRight[1]) + 1};
    }
}
