package com.coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class E993 {
    Map<Integer, int[]> parentMap = new HashMap<Integer, int[]>();

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0, null);
        int[] xv = parentMap.getOrDefault(x, new int[]{0, 10});
        int[] yv = parentMap.getOrDefault(y, new int[]{0, 20});

        System.out.println(Arrays.toString(xv));
        System.out.println(Arrays.toString(yv));

        return xv[0] == yv[0] && xv[1] == yv[1];
    }

    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if (parentMap.size() == 2) {
            return;
        }
        if (root == null) return;

        if (root.val == x || root.val == y) {
            if (parent == null) {
                parentMap.put(root.val, new int[]{depth, -1});
            } else {
                parentMap.put(root.val, new int[]{depth, parent.val});
            }
        }
        dfs(root.left, x, y, depth + 1, root);
        dfs(root.right, x, y, depth + 1, root);
    }
}
