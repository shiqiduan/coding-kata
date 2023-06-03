package com.coding;

public class M540 {
    public int singleNonDuplicate(int[] nums) {
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == nums[mid ^ 1]) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return nums[s];
    }

    public static void main(String[] args) {
        System.out.println(1 ^ 1);
        System.out.println(2 ^ 1);
        System.out.println(3 ^ 1);
        System.out.println(4 ^ 1);
        System.out.println(0 ^ 1);
    }
}
