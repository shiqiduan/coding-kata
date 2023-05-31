package com.coding;

public class M413 {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int ans = 0;

        int prev = nums[1];
        int delta = nums[1] - nums[0];
        int count = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - prev == delta) {
                count++;
            } else {
                delta = nums[i] - nums[i - 1];
                if (count >= 3) {
                    ans += (count - 1) * (count - 2) / 2;
                }
                count = 2;
            }
            prev = nums[i];
        }
        if (count >= 3) {
            ans += (count - 1) * (count - 2) / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        M413 m = new M413();

        System.out.println(m.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
        System.out.println(m.numberOfArithmeticSlices(new int[]{1, 2}));
        System.out.println(m.numberOfArithmeticSlices(new int[]{1, 2, 3}));
        System.out.println(m.numberOfArithmeticSlices(new int[]{1, 1, 1, 1}));
        System.out.println(m.numberOfArithmeticSlices(new int[]{1, 1, 1, 2, 3, 4}));
    }
}
