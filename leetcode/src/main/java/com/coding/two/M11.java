package com.coding.two;

/**
 * 核心是决定移动哪个指针。移动哪个指针都存在不确定性。
 * 可以确定的是，移动后，宽度是一样的，都会缩小。
 * 那么，机会在于，移动那边，可能有较大的机会。
 * <p>
 * 已知条件，已经知道相对小的值，则调整它，可能有更大的机会。
 * <p>
 */
public class M11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            int temp = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, temp);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
