package com.coding.two.binarytree;

import com.coding.TreeNode;

/**
 * 细节、边界条件
 */
public class M98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean isValidBST(TreeNode root, long max, long min) {
        if (root == null) return true;
        if (root.val >= max) return false;
        if (root.val <= min) return false;

        return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }

    private Long prev = null;

    /**
     * 中序遍历
     */
    public boolean isValidBS1(TreeNode root) {
        if (root == null) return true;

        boolean flag = isValidBST(root.left);

        if (prev == null) {
            prev = (long) root.val;
        } else {
            if (root.val < prev) {
                return false;
            }
            prev = (long) root.val;
        }
        return flag & isValidBST(root.right);
    }

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.pow(2, 31) - 1);
        System.out.println(Long.MIN_VALUE);
    }
}
