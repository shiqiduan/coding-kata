package com.coding;

import java.util.ArrayList;
import java.util.List;

public class M120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        M120 m = new M120();

        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(2));
        list.add(List.of(3, 4));
        list.add(List.of(6, 5, 7));
        list.add(List.of(4, 1, 8, 3));

        System.out.println(m.minimumTotal(list));
    }
}
