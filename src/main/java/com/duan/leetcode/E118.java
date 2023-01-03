package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class E118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> l0 = new ArrayList<>();
        l0.add(1);
        ret.add(l0);
        for (int i = 1; i < numRows; i++) {
            List<Integer> last = ret.get(i - 1);
            List<Integer> current = new ArrayList<>();
            current.add(last.get(0));
            for (int j = 1; j < i; j++) {
                current.add(last.get(j - 1) + last.get(j));
            }
            current.add(last.get(last.size() - 1));
            ret.add(current);
        }
        return ret;
    }
}
