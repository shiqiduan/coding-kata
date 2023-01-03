package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class S163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        long start = lower;
        List<String> ret = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == start) {
                start++;
                continue;
            }
            if ((nums[i] - start) == 1) {
                ret.add(start + "");
            } else {
                ret.add(start + "->" + (nums[i] - 1));
            }
            start = nums[i] + 1;
        }
        if(start == upper) {
            ret.add(start + "");
        } else if(start < upper) {
            ret.add(start + "->" + (upper - 1));
        }
        return ret;
    }
}
