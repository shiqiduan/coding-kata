package com.coding;

import java.util.Stack;

public class M1190 {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> cstack = new Stack<>();
        Stack<Integer> istack = new Stack<>();

        int current = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                cstack.push(c);
                istack.push(current);
            } else if (c == ')') {
                cstack.pop();
                Integer pop = istack.pop();
                reverse(sb, pop, current);
            } else {
                sb.append(c);
                current++;
            }
        }
        return sb.toString();
    }

    private void reverse(StringBuilder sb, int x, int y) {
        while (x < y) {
            char temp = sb.charAt(x);
            sb.setCharAt(x, sb.charAt(y));
            sb.setCharAt(y, temp);
            x++;
            y--;
        }
    }
}
