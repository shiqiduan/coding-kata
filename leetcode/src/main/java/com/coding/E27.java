package com.coding;

public class E27 {
    public int removeElement(int[] nums, int val) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] == val) {
                right++;
            } else {
                if (left != right) {
                    nums[left] = nums[right];
                }
                left++;
                right++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        E27 e = new E27();

        System.out.println(e.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(e.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}
