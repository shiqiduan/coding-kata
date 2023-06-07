package com.coding.easytwo;

import java.util.Stack;

public class E20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }

            if (stack.peek() == '(' && c == ')') {
                stack.pop();
            } else if (stack.peek() == '[' && c == ']') {
                stack.pop();
            } else if (stack.peek() == '{' && c == '}') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
