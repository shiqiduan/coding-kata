package com.coding.two;

/**
 * 同 E26， 双指针
 */
public class E27 {
    public int removeElement(int[] nums, int val) {
        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                last++;
                if (last != i) {
                    nums[last] = nums[i];
                }
            }
        }
        return last + 1;
    }

    public static void main(String[] args) {
        E27 e = new E27();

        System.out.println(e.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(e.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}
