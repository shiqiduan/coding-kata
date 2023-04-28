package com.coding;

public class E26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int a = 0, b = 1;
        while (b < nums.length) {
            if (nums[a] == nums[b]) {
                b++;
                continue;
            }
            nums[a + 1] = nums[b];
            a++;
            b++;
        }
        return a + 1;
    }

    public static void main(String[] args) {
        E26 e26 = new E26();
        System.out.println(e26.removeDuplicates(new int[]{1, 1, 2, 2, 3}));
    }
}
