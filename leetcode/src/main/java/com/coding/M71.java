package com.coding;

import java.util.Stack;

public class M71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] split = path.split("/");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (s.length() == 0) continue;

            if (s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
            sb.append("/");
        }
        return (sb.length() > 1) ? sb.deleteCharAt(sb.length() - 1).toString() : sb.toString();
    }

    public static void main(String[] args) {
        M71 m = new M71();

        System.out.println(m.simplifyPath("/home/"));
        System.out.println(m.simplifyPath("/"));
        System.out.println(m.simplifyPath("/./"));
        System.out.println(m.simplifyPath("/../"));
        System.out.println(m.simplifyPath("/.../"));
        System.out.println(m.simplifyPath("/.../."));
        System.out.println(m.simplifyPath("/.../.."));
        System.out.println(m.simplifyPath("/home//foo/"));
        System.out.println(m.simplifyPath("/a/./b/../../c/"));
        System.out.println(m.simplifyPath("a/./b/../../c/"));
        System.out.println(m.simplifyPath("/..."));
    }
}
