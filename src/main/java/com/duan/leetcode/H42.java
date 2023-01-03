package com.duan.leetcode;

public class H42 {
    public int trap(int[] height) {
        if(height.length == 1) return 0;

        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        int sum = 0;
        int rightMax = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i + 1]);
            int temp = Math.min(leftMax[i], rightMax) - height[i];
            if (temp > 0) {
                sum += temp;
            }
        }
        return sum;
    }
}
