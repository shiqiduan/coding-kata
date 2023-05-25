package com.coding;

public class M162 {
    public int findPeakElement(int[] nums) {
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;

            if (mid == 0 && nums[mid] > nums[mid + 1]
                    || mid == (nums.length - 1) && nums[mid] > nums[mid - 1]
                    || mid >= 1 && mid < nums.length - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid] > nums[mid + 1]) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        M162 m = new M162();

        System.out.println(m.findPeakElement(new int[]{1, 2}));

        System.out.println(m.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
        System.out.println(m.findPeakElement(new int[]{1}));


        System.out.println(m.findPeakElement(new int[]{1, 2, 3, 1}));
    }
}
