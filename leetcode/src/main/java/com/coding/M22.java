package com.coding;

import java.util.ArrayList;
import java.util.List;

public class M22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backstack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backstack(List<String> ret, StringBuilder sb, int open, int close, int n) {
        if (sb.length() == n * 2) {
            ret.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append('(');
            backstack(ret, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(')');
            backstack(ret, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        M22 m = new M22();
        List<String> strings = m.generateParenthesis(6);
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }
}
