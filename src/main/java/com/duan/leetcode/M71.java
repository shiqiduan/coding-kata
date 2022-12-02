package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class M71 {
    public String simplifyPath(String path) {
        List<String> stack = new ArrayList<>();
        stack.add("/");
        path = path + "/";

        StringBuilder temp = new StringBuilder();
        for (int i = 1; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '/') {
                if (temp.length() == 0) continue;

                String str = temp.toString();
                temp = new StringBuilder();
                if (str.equals(".")) {
                    continue;
                }
                if (str.equals("..")) {
                    if (stack.size() > 1) {
                        stack.remove(stack.size() - 1);
                        stack.remove(stack.size() - 1);
                    }
                    continue;
                }
                stack.add(str);
                stack.add("/");
            } else {
                temp.append(c);
            }
        }
        if (stack.size() > 1 && stack.get(stack.size() - 1).equals("/")) {
            stack.remove(stack.size() - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        M71 m = new M71();

        System.out.println(m.simplifyPath("/a/./b/../../c/"));
        System.out.println(m.simplifyPath("/"));
        System.out.println(m.simplifyPath("/home"));
        System.out.println(m.simplifyPath("/home/"));
        System.out.println(m.simplifyPath("/../"));
        System.out.println(m.simplifyPath("/../aaa"));
        System.out.println(m.simplifyPath("/aaa///a/b//a"));
        System.out.println(m.simplifyPath("/home/../../.."));
    }
}
