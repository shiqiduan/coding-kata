package com.coding;

public class M260 {
    public int[] singleNumber(int[] nums) {
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp ^= nums[i];
        }

        int x = Integer.toBinaryString(temp).length() - Integer.toBinaryString(temp).lastIndexOf("1") - 1;
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] >> x & 1) == 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        return new int[]{a, b};
    }

    private static void getIndex(int n) {
        int x = Integer.toBinaryString(n).length() - Integer.toBinaryString(n).lastIndexOf("1") - 1;
        System.out.println(Integer.toBinaryString(n) + " " + x + " " + (int) (n >> x & 1));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            getIndex(i);
        }
    }
}
