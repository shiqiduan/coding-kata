package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class E257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if (root == null) return ret;
        if (root.left == null && root.right == null) {
            ret.add(root.val + "");
            return ret;
        }
        StringBuilder current = new StringBuilder();
        current.append(root.val);

        if (root.left != null) {
            bfs(root.left, ret, current);
        }

        if (root.right != null) {
            bfs(root.right, ret, current);
        }
        return ret;
    }

    private void bfs(TreeNode node, List<String> ret, StringBuilder current) {
        current.append("->").append(node.val);
        int i = current.lastIndexOf("->");

        // 叶子节点.
        if (node.left == null && node.right == null) {
            ret.add(current.toString());
            current.delete(i, current.length());
            return;
        }

        if (node.left != null) {
            bfs(node.left, ret, current);
        }
        if (node.right != null) {
            bfs(node.right, ret, current);
        }
        current.delete(i, current.length());
    }

    public static void main(String[] args) {
        E257 e = new E257();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.right = n5;

        System.out.println(e.binaryTreePaths(n1));

        System.out.println(e.binaryTreePaths(null));
    }
}
