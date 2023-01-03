package com.duan.leetcode;

public class S129 {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        StringBuilder sb = new StringBuilder();
        return dfs(root, sb, 0);
    }

    private int dfs(TreeNode node, StringBuilder sb, int sum) {
        if(node == null) {
            return sum;
        }
        sb.append(node.val);
        if(node.left == null && node.right == null) {
            sum += Integer.parseInt(sb.toString());
        } else {
            sum = dfs(node.left, sb, sum);
            sum = dfs(node.right, sb, sum);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sum;
    }
}
