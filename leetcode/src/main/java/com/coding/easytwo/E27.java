package com.coding.easytwo;

/**
 * 同 E26， 双指针
 */
public class E27 {
    public int removeElement(int[] nums, int val) {
        int a = -1, b = 0;
        while (b < nums.length) {
            if (nums[b] != val) {
                a++;
                if (a != b) {
                    nums[a] = nums[b];
                }
            }
            b++;
        }
        return a + 1;
    }

    public static void main(String[] args) {
        E27 e = new E27();

        System.out.println(e.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(e.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}
