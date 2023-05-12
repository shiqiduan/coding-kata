package com.coding;

/**
 * 大于一半的意思是什么？ 摩尔投票法
 */
public class E169 {
    public int majorityElement(int[] nums) {
        int ret = nums[0], count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ret) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                ret = nums[i];
                count = 1;
            }
        }
        return ret;
    }
}
