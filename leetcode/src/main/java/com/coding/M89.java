package com.coding;

import java.util.ArrayList;
import java.util.List;

public class M89 {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            ans.add(i ^ (i / 2));
        }
        return ans;
    }
}
