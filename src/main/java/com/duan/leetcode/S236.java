package com.duan.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class S236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q) return root;

        List<List<TreeNode>> ret = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();
        set.add(p);
        set.add(q);
        bfs(root, set, path, ret);
        List<TreeNode> a = ret.get(0);
        List<TreeNode> b = ret.get(1);

        System.out.println(a);
        System.out.println(b);

        int len = Math.min(a.size(), b.size());

        TreeNode parent = root;
        for (int i = 0; i < len; i++) {
            if (a.get(i) != b.get(i)) {
                break;
            } else {
                parent = a.get(i);
            }
        }
        return parent;
    }

    private void bfs(TreeNode root, Set<TreeNode> set, List<TreeNode> path, List<List<TreeNode>> ret) {
        if(root == null && set.isEmpty()) {
            return;
        }
        path.add(root);
        if(set.contains(root)) {
            // 加入结果
            set.remove(root);
            List<TreeNode> a = new ArrayList<>();
            a.addAll(path);
            ret.add(a);
        }
        bfs(root.left, set, path, ret);
        bfs(root.right, set, path, ret);
        path.remove(root);
    }
}
