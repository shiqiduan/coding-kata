package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class S412 {
    public List<String> fizzBuzz(final int n) {
        final List<String> ret = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            final int x3 = i % 3;
            final int x5 = i % 5;

            if (x3 == 0 && x5 == 0) {
                ret.add("FizzBuzz");
            } else if (x3 == 0) {
                ret.add("Fizz");
            } else if (x5 == 0) {
                ret.add("Buzz");
            } else {
                ret.add(i + "");
            }
        }
        return ret;
    }
}
