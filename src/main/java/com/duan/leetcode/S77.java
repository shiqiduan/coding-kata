package com.duan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        track(ret, list, n, k);
        return ret;
    }

    private void track(List<List<Integer>> ret, List<Integer> list, int n, int k) {
        if(list.size() == k) {
            List<Integer> a = new ArrayList<>();
            a.addAll(list);
            ret.add(a);
            return;
        }
        Integer current = 1;
        if(!list.isEmpty()) {
            current = list.get(list.size() - 1) + 1;
        }
        for (int i = current; i <= n ; i++) {
            list.add(i);
            track(ret, list, n, k);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        S77 s = new S77();
        System.out.println(Arrays.toString(s.combine(4, 2).toArray()));
        System.out.println(Arrays.toString(s.combine(1, 1).toArray()));
    }
}
