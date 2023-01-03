package com.duan.leetcode;

import java.util.Arrays;

public class S238 {
    public int[] productExceptSelf(int[] nums) {
        int[] answers = new int[nums.length];
        answers[0] = 1;
        for (int i = 1; i < nums.length ; i++) {
            answers[i] = answers[i - 1] * nums[i - 1];
        }
        int b = 1;
        for (int i = nums.length - 2; i >= 0 ; i--) {
            b = b * nums[i + 1];
            answers[i] = answers[i] * b;
        }
        return answers;
    }

    public static void main(String[] args) {
        S238 s = new S238();
        System.out.println(Arrays.toString(s.productExceptSelf(new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(s.productExceptSelf(new int[] {1,2})));
    }
}
