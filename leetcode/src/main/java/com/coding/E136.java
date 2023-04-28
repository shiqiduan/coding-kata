package com.coding;

public class E136 {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ret ^= nums[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(3 ^ 3 ^ 1);

        E136 a = new E136();
        System.out.println(a.singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(a.singleNumber(new int[]{2, 2, 1}));
    }
}
