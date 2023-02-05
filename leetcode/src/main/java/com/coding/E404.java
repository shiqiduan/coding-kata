package com.coding;

public class E404 {
    private int leftSum;
    public int sumOfLeftLeaves(TreeNode root) {
        leftSum = 0;
        track(root);
        return leftSum;
    }

    private void track(TreeNode node) {
        if(node == null) return;
        if(node.left != null && node.left.left == null && node.left.right == null) {
            leftSum += node.left.val;
        }
        track(node.left);
        track(node.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        E404 e = new E404();

        System.out.println(e.sumOfLeftLeaves(n1));
    }
}
