package com.duan;

import java.util.ArrayList;
import java.util.List;

public class S228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        if(nums.length == 0) return ret;

        StringBuilder sb = new StringBuilder();
        sb.append("" + nums[0]);
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1] + 1) {
                if(index != i - 1) {
                    sb.append("->").append(nums[i - 1]);
                }
                ret.add(sb.toString());
                sb = new StringBuilder();
                sb.append(nums[i]);
                index = i;
            }
        }
        if(sb.length() > 0) {
            if(index != nums.length - 1) {
                sb.append("->").append(nums[nums.length - 1]);
            }
            ret.add(sb.toString());
        }
        return ret;
    }

    public static void main(String[] args) {
        S228 s = new S228();
        System.out.println(s.summaryRanges(new int[] {0,1,2,4,5,7}));
        System.out.println(s.summaryRanges(new int[] {}));
        System.out.println(s.summaryRanges(new int[] {0}));
        System.out.println(s.summaryRanges(new int[] {0,1,10}));
        System.out.println(s.summaryRanges(new int[] {0,2,3,4,6,8,9}));
    }
}
