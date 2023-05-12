package com.coding;

public class E108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return track(nums, 0, nums.length - 1);
    }

    private TreeNode track(int[] nums, int start, int end) {
        if (start > end) return null;
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = track(nums, start, mid - 1);
        node.right = track(nums, mid + 1, end);
        return node;
    }
}
