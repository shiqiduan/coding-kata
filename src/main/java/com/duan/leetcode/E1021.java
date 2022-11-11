package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class E1021 {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        List<Character> stack = new ArrayList<>();

        int level = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.add(c);
                level++;
                continue;
            }
            if(c == ')') {
                level--;
                if(level == 1) {
                    appendFromList(sb, stack, level);
                    sb.append(c);
                    removeFromList(stack, level);
                } else if(level == 0) {
                    removeFromList(stack, level);
                } else {
                    stack.add(c);
                }
            }
        }
        return sb.toString();
    }

    private void removeFromList(List<Character> list, int index) {
        for (int j = list.size() - 1; j >= index; j--) {
            list.remove(j);
        }
    }

    private void appendFromList(StringBuilder sb, List<Character> list, int from) {
        for (int i = from; i < list.size(); i++) {
            sb.append(list.get(i));
        }
    }
}
