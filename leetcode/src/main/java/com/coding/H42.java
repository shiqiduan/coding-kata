package com.coding;

public class H42 {
    public int trap(int[] height) {
        if (height.length == 2) return 0;

        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int leftMax = height[0];
        int ret = 0;
        for (int i = 0; i < height.length; i++) {
            int temp = Math.min(leftMax, rightMax[i]) - height[i];
            if (temp > 0) {
                ret += temp;
            }
            leftMax = Math.max(leftMax, height[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        H42 e = new H42();
        System.out.println(e.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
