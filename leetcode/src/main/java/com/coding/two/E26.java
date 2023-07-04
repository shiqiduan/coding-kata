package com.coding.two;

/**
 * 双指针
 */
public class E26 {
    public int removeDuplicates(int[] nums) {
        int last = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[last] != nums[i]) {
                last++;
                if (last != i) {
                    nums[last] = nums[i];
                }
            }
        }
        return last + 1;
    }

    public static void main(String[] args) {
        E26 e26 = new E26();
        System.out.println(e26.removeDuplicates(new int[]{1, 1, 2, 2, 3}));
    }
}
