package com.duan.leetcode;

public class S42 {
    public int trap(int[] height) {
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];

        int max = height[0];
        for (int i = 0; i < size; i++) {
            max = Math.max(max, height[i]);
            leftMax[i] = max;
        }
        max = height[size - 1];
        for (int i = (size - 1); i >= 0; i--) {
            max = Math.max(max, height[i]);
            rightMax[i] = max;
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            int h = Math.min(leftMax[i], rightMax[i]);
            sum += h - height[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        S42 s = new S42();
        System.out.println(s.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
