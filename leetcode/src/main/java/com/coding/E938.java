package com.coding;

public class E938 {
    private int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return sum;

        rangeSumBST(root.left, low, high);

        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        rangeSumBST(root.right, low, high);
        return sum;
    }
}
