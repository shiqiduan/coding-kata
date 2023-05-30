package com.coding;

public class M654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int x, int y) {
        if (x > y) return null;

        int maxIndex = getMaxIndex(nums, x, y);
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = dfs(nums, x, maxIndex - 1);
        node.right = dfs(nums, maxIndex + 1, y);
        return node;
    }

    private int getMaxIndex(int[] nums, int x, int y) {
        int ans = x;
        for (int i = x + 1; i <= y; i++) {
            if (nums[i] > nums[ans]) {
                ans = i;
            }
        }
        return ans;
    }
}
