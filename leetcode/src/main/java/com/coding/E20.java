package com.coding;

import java.util.ArrayList;
import java.util.List;

public class E20 {
    public boolean isValid(String s) {
        List<Character> stack = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) return false;
                char last = stack.get(stack.size() - 1);
                if (last == '(' && c == ')'
                        || last == '{' && c == '}'
                        || last == '[' && c == ']') {
                    stack.remove(stack.size() - 1);
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
