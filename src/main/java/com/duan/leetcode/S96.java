package com.duan.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：拆解问题，定义问题的思路。很多时候，问题不是直接的。需要拆解成子问题。
 *
 * 寻找组织或者结构上面的关系。包含，组合等
 */
public class S96 {
    public int numTrees(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;

        Map<Integer, Long> temp = new HashMap<>();
        temp.put(0, 1L);
        temp.put(1, 1L);
        return (int) func(n, temp);
    }

    private long func(int n, Map<Integer, Long> temp) {
        if(temp.containsKey(n)) return temp.get(n);
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += func(i - 1, temp) * func(n - i, temp);
        }
        temp.put(n, sum);
        return sum;
    }
}
