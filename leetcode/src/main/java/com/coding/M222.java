package com.coding;

public class M222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int height = getHeight(root);
        int a = 1, b = (int) Math.pow(2, height);
        while (a <= b) {
            int mid = a + (b - a) / 2;

            if (found((int) (mid + Math.pow(2, height) - 1), root)) {
                a = mid + 1;
            } else {
                b = mid - 1;
            }
        }

        return (int) (Math.pow(2, height) - 1 + a - 1);
    }

    private int getHeight(TreeNode root) {
        TreeNode left = root;
        int ans = 0;
        while (left != null && left.left != null) {
            left = left.left;
            ans++;
        }
        return ans;
    }

    private boolean found(int num, TreeNode root) {
        String a = Integer.toBinaryString(num);
        TreeNode current = root;
        int i = 1;
        while (i < a.length() && current != null) {
            if (a.charAt(i) == '1') {
                current = current.right;
            } else {
                current = current.left;
            }
            i++;
        }
        return current != null;
    }
}
