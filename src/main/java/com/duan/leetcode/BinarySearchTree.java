package com.duan.leetcode;

public class BinarySearchTree {

    public static TreeNode findInOrderSuccessor(TreeNode node) {
        if (node == null) return null;

        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        while (node.parent != null) {
            if (node.parent.left == node) {
                return node.parent;
            }
            node = node.parent;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode n20 = new TreeNode(20);
        TreeNode n9 = new TreeNode(9);
        TreeNode n5 = new TreeNode(5);
        TreeNode n12 = new TreeNode(12);
        TreeNode n11 = new TreeNode(11);
        TreeNode n14 = new TreeNode(14);
        TreeNode n25 = new TreeNode(25);

        n20.left = n9;
        n9.parent = n20;
        n20.right = n25;
        n25.parent = n20;
        n9.left = n5;
        n5.parent = n9;
        n9.right = n12;
        n12.parent = n9;
        n12.left = n11;
        n11.parent = n12;
        n12.right = n14;
        n14.parent = n12;

        System.out.println(BinarySearchTree.findInOrderSuccessor(n9));
        System.out.println(BinarySearchTree.findInOrderSuccessor(n20));
        System.out.println(BinarySearchTree.findInOrderSuccessor(n25));
        System.out.println(BinarySearchTree.findInOrderSuccessor(n14));
        System.out.println(BinarySearchTree.findInOrderSuccessor(n12));
        System.out.println(BinarySearchTree.findInOrderSuccessor(n5));
        System.out.println(BinarySearchTree.findInOrderSuccessor(n11));
    }
}
