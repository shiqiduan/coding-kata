package com.coding;

import java.util.ArrayList;
import java.util.List;

public class M1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (index >= target.length) {
                return ans;
            }
            if (target[index] == i) {
                ans.add("Push");
                index++;
            } else if (target[index] > i) {
                ans.add("Push");
                ans.add("Pop");
            }
        }
        return ans;
    }
}
