package com.coding;

import java.util.ArrayList;
import java.util.List;

public class M784 {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        dfs(s, 0, new StringBuilder(), ans);
        return ans;
    }

    private void dfs(String s, int index, StringBuilder sb, List<String> ans) {
        if (index == s.length()) {
            ans.add(sb.toString());
            return;
        }

        char c = s.charAt(index);
        if (!Character.isLetter(c)) {
            sb.append(c);
            dfs(s, index + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        sb.append(c);
        dfs(s, index + 1, sb, ans);
        sb.deleteCharAt(sb.length() - 1);

        if (Character.isLowerCase(c)) {
            c = Character.toUpperCase(c);
        } else {
            c = Character.toLowerCase(c);
        }

        sb.append(c);
        dfs(s, index + 1, sb, ans);
        sb.deleteCharAt(sb.length() - 1);
    }
}
