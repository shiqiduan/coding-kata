package com.duan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class M106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(inMap, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode build(Map<Integer, Integer> inMap, int[] postorder, int fi, int ti, int fp, int tp) {
        if (fi > ti || fp > tp) return null;
        int val = postorder[tp];
        TreeNode node = new TreeNode(val);
        Integer index = inMap.get(val);

        int rightCount = ti - index;
        int leftCount = index - fi;

        if(leftCount == 0) {
            node.left = null;
        } else {
            node.left = build(inMap, postorder, fi, index - 1, fp, fp + leftCount - 1);
        }
        if(rightCount == 0) {
            node.right = null;
        } else {
            node.right = build(inMap, postorder, index + 1, ti, tp - rightCount, tp - 1);
        }
        return node;
    }

    public static void main(String[] args) {
        M106 m = new M106();
        m.buildTree(new int[]{9,3,15,20,7}, new int[] {9, 15, 7, 20, 3});
    }
}
