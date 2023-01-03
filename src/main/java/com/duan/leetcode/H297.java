package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class H297 {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        List<TreeNode> levelList = new ArrayList<>();
        levelList.add(root);
        while (!levelList.isEmpty()) {
            List<TreeNode> newLeveList = new ArrayList<>();
            for (int i = 0; i < levelList.size(); i++) {
                TreeNode node = levelList.get(i);
                if (node != null) {
                    sb.append(node.val);
                    newLeveList.add(node.left);
                    newLeveList.add(node.right);
                } else {
                    sb.append("");
                }
                sb.append(",");
            }
            levelList = newLeveList;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] split = data.split(",");

        Integer rootValue = Integer.parseInt(split[0]);
        TreeNode root = new TreeNode(rootValue);

        List<TreeNode> level = new ArrayList<>();
        level.add(root);

        int index = 0;
        while (!level.isEmpty()) {
            List<TreeNode> newLevelList = new ArrayList<>();
            for (int i = 0; i < level.size(); i++) {
                TreeNode node = level.get(i);
                if (node == null) {
                    continue;
                }
                index++;
                if (index >= split.length) {
                    continue;
                }

                String leftValue = split[index];
                if (!leftValue.isEmpty()) {
                    node.left = new TreeNode(Integer.parseInt(leftValue));
                    newLevelList.add(node.left);
                }
                index++;
                if (index >= split.length) {
                    continue;
                }
                String rightValue = split[index];
                if (!rightValue.isEmpty()) {
                    node.right = new TreeNode(Integer.parseInt(rightValue));
                    newLevelList.add(node.right);
                }
            }
            level = newLevelList;
        }
        return root;
    }

    public static void main(String[] args) {
        H297 h = new H297();

        TreeNode node = h.deserialize("1,2,3,,,4,5");
        System.out.println(h.serialize(node));

        node = h.deserialize("1,2,3,,,4,5,,,,");
        System.out.println(h.serialize(node));
    }
}
