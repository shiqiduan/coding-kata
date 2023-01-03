package com.duan.leetcode;


import java.util.Collections;
import java.util.List;

public class S10003 {

    public static int smallestNonconstructValue(List<Integer> nums) {
        Collections.sort(nums);
        int max = 0;
        for (Integer a : nums) {
            if (a > (max + 1)) {
                break;
            }
            max = max + a;
        }
        return max + 1;
    }

}
