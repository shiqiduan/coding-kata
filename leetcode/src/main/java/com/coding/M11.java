package com.coding;

public class M11 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ret = 0;
        while (l < r) {
            int s = Math.min(height[l], height[r]) * (r - l);
            ret = Math.max(ret, s);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ret;
    }
}
