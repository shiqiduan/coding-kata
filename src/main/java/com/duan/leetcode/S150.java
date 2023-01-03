package com.duan.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class S150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];

            if (!set.contains(t)) {
                stack.push(Integer.parseInt(t));
                continue;
            }
            int b = stack.pop(), a = stack.pop();
            switch (t) {
                case "+":
                    stack.push(a + b);
                    break;
                case "-":
                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(a * b);
                    break;
                case "/":
                    stack.push(a / b);
                    break;
                default:
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        S150 s = new S150();

        System.out.println(s.evalRPN(new String[]{"1", "2", "+"}));
        System.out.println(s.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(s.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
