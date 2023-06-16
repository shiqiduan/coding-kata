package com.coding.one;

import java.util.Arrays;

public class M918 {
    /**
     * 类似：连续子数据最大和
     */
    public int maxSubarraySumCircular(int[] nums) {
        int leftMax = nums[0], rightMax = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            if (leftMax + nums[i] < 0) {
                for (int j = nums.length - 2; j >= i; j--) {
                    if (rightMax + nums[j] < 0) {
                        break;
                    }
                    rightMax += nums[j];
                }
                break;
            }
            leftMax += nums[i];
        }


        return Math.max(maxSubArraySum(nums), leftMax + rightMax);
    }

    private int maxSubArraySum(int[] nums) {
        int ans = nums[0], temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            if (temp < 0) {
                temp = 0;
            } else {
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};

        nums = Arrays.copyOf(nums, 2 * nums.length);

        System.out.println(Arrays.toString(nums));
    }
}
