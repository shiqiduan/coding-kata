package com.coding;

import java.util.ArrayList;
import java.util.List;

public class M77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        track(1, n, k, new ArrayList<>(), ret);
        return ret;
    }

    private void track(int s, int n, int k, List<Integer> list, List<List<Integer>> ret) {
        if (list.size() == k) {
            ret.add(new ArrayList<>(list));
            return;
        }

        for (int i = s; i <= n; i++) {
            list.add(i);
            track(i + 1, n, k, list, ret);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        M77 m = new M77();
        System.out.println(m.combine(4, 2));
    }
}
