package com.coding.two;

import java.util.Arrays;

/**
 * 如何证明双指针一定可以找到答案
 */
public class M167 {
    public int[] twoSum(int[] numbers, int target) {
        int s = 0, e = numbers.length - 1;
        while (s < e) {
            int sum = numbers[s] + numbers[e];
            if (sum == target) {
                return new int[]{s + 1, e + 1};
            } else if (sum > target) {
                e--;
            } else {
                s++;
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        M167 m = new M167();
        System.out.println(Arrays.toString(m.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(m.twoSum(new int[]{2, 3, 4}, 6)));
    }
}
