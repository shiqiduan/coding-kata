package com.coding;

import java.util.HashMap;
import java.util.Map;

public class M105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, map, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, Map<Integer, Integer> map, int px, int py, int ix, int iy) {
        if (px > py) {
            return null;
        }
        if (px == py) {
            return new TreeNode(preorder[px]);
        }
        int rootValue = preorder[px];
        Integer index = map.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        int leftSize = index - ix;
        root.left = buildTree(preorder, map, px + 1, px + leftSize, ix, index - 1);
        root.right = buildTree(preorder, map, px + leftSize + 1, py, index + 1, iy);
        return root;
    }

    public static void main(String[] args) {
        M105 m = new M105();
        System.out.println(m.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}
