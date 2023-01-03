package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class S116 {
    public Node connect(Node root) {
        if(root == null) return null;
        List<Node> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            List<Node> templist = new ArrayList<>();

            Node f = list.get(0);

            if(f.left != null) {
                templist.add(f.left);
            }
            if(f.right != null) {
                templist.add(f.right);
            }

            for (int i = 1; i < list.size(); i++) {
                f.next = list.get(i);
                f = f.next;

                if(f.left != null) {
                    templist.add(f.left);
                }
                if(f.right != null) {
                    templist.add(f.right);
                }
            }
            list = templist;
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};