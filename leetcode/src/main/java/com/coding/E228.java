package com.coding;

import java.util.ArrayList;
import java.util.List;

public class E228 {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new ArrayList<String>();

        List<String> ret = new ArrayList<String>();
        int s = nums[0], e = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != (nums[i - 1] + 1)) {
                if (s == e) {
                    ret.add(String.valueOf(s));
                } else {
                    ret.add(s + "->" + e);
                }
                s = nums[i];
            }
            e = nums[i];
        }
        if (s == e) {
            ret.add(String.valueOf(s));
        } else {
            ret.add(s + "->" + e);
        }
        return ret;
    }
}
