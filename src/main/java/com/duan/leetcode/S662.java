package com.duan.leetcode;

import java.util.*;

/**
 * 宽度是叶子节点的节点数
 * 核心是编号问题
 *
 */
public class S662 {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 1;
        List<Pair> arr = new ArrayList<Pair>();
        arr.add(new Pair(root, 1));
        while (!arr.isEmpty()) {
            List<Pair> temp = new ArrayList<>();
            for(Pair p : arr) {
                TreeNode node = p.l;
                int index = p.r;
                if(node.left != null) {
                    temp.add(new Pair(node.left, 2 * index));
                }
                if(node.right != null) {
                    temp.add(new Pair(node.right, 2 * index + 1));
                }
            }
            res = Math.max(res, arr.get(arr.size() - 1).r - arr.get(0).r + 1);
            arr = temp;
        }
        return res;
    }
}

class Pair {
    TreeNode l;
    Integer r;

    Pair(TreeNode l, Integer r) {
        this.l = l;
        this.r = r;
    }
}