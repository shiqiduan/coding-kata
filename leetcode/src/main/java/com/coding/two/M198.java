package com.coding.two;

public class M198 {
    /**
     * f(n) = max(f(n - 1), f(n - 2) + current)
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int a = 0, b = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int c = Math.max(a + nums[i], b);
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        M198 m = new M198();
        System.out.println(m.rob(new int[]{1, 2, 3, 1}));
        System.out.println(m.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(m.rob(new int[]{2}));
        System.out.println(m.rob(new int[]{7, 2}));
    }
}
