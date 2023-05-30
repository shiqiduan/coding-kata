package com.coding;

import java.util.HashMap;
import java.util.Map;

public class M106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(postorder, inorder, postorder.length - 1, 0, inorder.length - 1, map);
    }

    private TreeNode buildTree(int[] postorder, int[] inorder, int root, int x, int y, Map<Integer, Integer> map) {
        if (x > y) return null;
        if (x == y) return new TreeNode(inorder[x]);

        TreeNode rootNode = new TreeNode(postorder[root]);
        Integer index = map.get(postorder[root]);

        int rightLen = y - index;
        if (rightLen > 0) {
            rootNode.right = buildTree(postorder, inorder, root - 1, index + 1, y, map);
        }

        int leftLen = index - x;
        if (leftLen > 0) {
            int leftRoot = root - y + index - 1;
            rootNode.left = buildTree(postorder, inorder, leftRoot, x, index - 1, map);
        }
        return rootNode;
    }
}
