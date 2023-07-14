package com.coding.two;

public class E136 {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(10 ^ 10);
    }
}
