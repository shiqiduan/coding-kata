package com.coding.easytwo;

import com.coding.TreeNode;

public class E108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int x, int y) {
        if (x == y) return new TreeNode(nums[x]);
        if (x > y) return null;
        int mid = x + (y - x) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, x, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, y);
        return root;
    }
}
