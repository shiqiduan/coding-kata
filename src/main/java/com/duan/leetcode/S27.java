package com.duan.leetcode;

public class S27 {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        for (int i = 0; i < len;) {
            if(nums[i] == val) {
                len--;
                swap(nums, i, len);
            } else {
                i++;
            }
        }
        return len;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        S27 s = new S27();

        System.out.println(s.removeElement(new int[]{3,2,2,3}, 3) + " = " + 2);

        System.out.println(s.removeElement(new int[]{}, 3) + " = " + 0);
    }
}
