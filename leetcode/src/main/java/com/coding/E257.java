package com.coding;

import java.util.ArrayList;
import java.util.List;

public class E257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<String>();
        List<Integer> list = new ArrayList<>();
        track(root, list, ret);
        return ret;
    }

    private void track(TreeNode node, List<Integer> current, List<String> ret) {
        if (node == null) return;

        current.add(node.val);

        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < current.size() - 1; i++) {
                sb.append(current.get(i));
                sb.append("->");
            }
            sb.append(current.get(current.size() - 1));
            ret.add(sb.toString());
        } else {
            track(node.left, current, ret);
            track(node.right, current, ret);
        }
        current.remove(current.size() - 1);
    }
}
