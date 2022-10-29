package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class S32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        // 使用下标
        List<Integer> stack = new ArrayList<>();
        stack.add(0);
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.add(i);
                continue;
            }
            char c = s.charAt(i);
            Character peek = s.charAt(stack.get(stack.size() - 1));
            if (peek == '(' && c == ')') {
                stack.remove(stack.size() - 1);
                if (stack.isEmpty()) {
                    max = Math.max(max, i + 1);
                } else {
                    max = Math.max(max, i - stack.get(stack.size() - 1));
                }
            } else {
                stack.add(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        S32 s = new S32();
        System.out.println(s.longestValidParentheses("(()"));
        System.out.println(s.longestValidParentheses(")()())"));
        System.out.println(s.longestValidParentheses("(()(()()(()()()"));
        System.out.println(s.longestValidParentheses("())"));
    }
}
