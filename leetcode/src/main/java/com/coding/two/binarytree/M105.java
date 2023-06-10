package com.coding.two.binarytree;

import com.coding.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class M105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, inMap);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int px, int py, int ix, int iy, Map<Integer, Integer> inMap) {
        if (px == py) return new TreeNode(preorder[px]);
        if (px > py) return null;

        TreeNode root = new TreeNode(preorder[px]);

        Integer rootIndex = inMap.get(root.val);

        int leftLen = rootIndex - ix;
        int rightLen = iy - rootIndex;

        root.left = buildTree(preorder, inorder, px + 1, px + leftLen, ix, ix + leftLen - 1, inMap);
        root.right = buildTree(preorder, inorder, py - rightLen + 1, py, rootIndex + 1, rootIndex + rightLen, inMap);
        return root;
    }

    public static void main(String[] args) {
        M105 m = new M105();
        System.out.println(m.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}
