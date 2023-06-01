package com.coding;

import java.util.ArrayList;
import java.util.List;

public class M131 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(String s, int i, List<String> list, List<List<String>> ans) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isp(s, i, j)) {
                list.add(s.substring(i, j + 1));
                dfs(s, j + 1, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isp(String s, int x, int y) {
        if (x == y) return true;
        if (x > y) return false;
        while (x < y) {
            if (s.charAt(x) != s.charAt(y)) {
                return false;
            }
            x++;
            y--;
        }
        return true;
    }
}
