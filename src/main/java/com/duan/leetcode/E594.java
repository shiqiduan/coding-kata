package com.duan.leetcode;

import java.util.Arrays;

public class E594 {
    public int findLHS(int[] nums) {
        if (nums.length == 1) return 0;

        Arrays.sort(nums);

        int maxLen = 0;
        int start = 0, end = 0;
        int flag = 0;

        while ((nums.length - start) > maxLen) {
            if (flag == 0) {
                end++;
                while (end < nums.length && ((nums[end] - nums[start]) == 1 || nums[end] == nums[start])) {
                    if (nums[end] - nums[start] == 1) {
                        maxLen = Math.max(end - start + 1, maxLen);
                    }
                    end++;
                }
                flag = 1;
            } else {
                start++;
                while (start < end && end < nums.length) {
                    if ((nums[end] - nums[start]) == 1) {
                        maxLen = Math.max(end - start + 1, maxLen);
                        break;
                    }
                    start++;
                }
                flag = 0;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        E594 e = new E594();

        System.out.println(e.findLHS(new int[]{1, 1, 1, 1}));
        System.out.println(e.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
        System.out.println(e.findLHS(new int[]{1, 2, 2, 1}));
    }
}
