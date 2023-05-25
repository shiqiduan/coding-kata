package com.coding;

import java.util.Set;
import java.util.Stack;

public class M150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        Set<String> set = Set.of("+", "-", "*", "/");

        for (int i = 0; i < tokens.length; i++) {
            if (!set.contains(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
                continue;
            }
            int b = stack.pop();
            int a = stack.pop();

            int ret = switch (tokens[i]) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                case "/" -> a / b;
                default -> throw new IllegalStateException("Unexpected value: " + tokens[i]);
            };
            stack.push(ret);
        }
        return stack.pop();
    }
}
