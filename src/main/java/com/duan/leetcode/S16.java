package com.duan.leetcode;

import java.util.Arrays;

/**
 * 三数之和 = 双指针 + 排序
 */
public class S16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ret = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1; int end = nums.length - 1;
            while (start < end) {
                int temp = nums[i] + nums[start] + nums[end];
                if(target - temp == 0) {
                    return target;
                }
                if(Math.abs(target - temp) < Math.abs(target - ret)) {
                    ret = temp;
                }
                if(temp >= target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        S16 s = new S16();
        System.out.println(s.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println(s.threeSumClosest(new int[]{0,0,0}, 1));
        System.out.println(s.threeSumClosest(new int[]{0,1,2}, 3));
    }
}
