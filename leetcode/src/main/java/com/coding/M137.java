package com.coding;

public class M137 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int temp = 0;
            for (int j = 0; j < nums.length; j++) {
                temp += (nums[j] >> i & 1);
            }
            ans |= (temp % 3) << i;
        }
        return ans;
    }

    public static void main(String[] args) {
        M137 m = new M137();

        System.out.println(m.singleNumber(new int[]{2, 2, 3, 2}));
    }
}
