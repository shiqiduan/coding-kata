package com.duan.leetcode;

public class S108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        track(nums, 0, mid - 1, root, true);
        track(nums, mid + 1, nums.length - 1, root, false);
        return root;
    }

    private void track(int[] nums, int x, int y, TreeNode parent, boolean left) {
        if(y < x) return;

        int mid = x + (y - x + 1) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        if(left) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        track(nums, x, mid - 1, node, true);
        track(nums, mid + 1, y, node, false);
    }
}
