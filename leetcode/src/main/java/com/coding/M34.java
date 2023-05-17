package com.coding;

/**
 * 好难的二分查找
 */
public class M34 {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false) - 1;
        if (left <= right && right < nums.length && nums[left] == target && nums[right] == target) {
            return new int[]{left, right};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int l = 0, r = nums.length - 1, ans = nums.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((lower && nums[mid] >= target) || nums[mid] > target) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        M34 m = new M34();

        System.out.println(m.binarySearch(new int[]{5, 7, 7, 8, 8, 10}, 6, false));
        System.out.println(m.binarySearch(new int[]{5, 7, 7, 8, 8, 10}, 7, false));
        System.out.println(m.binarySearch(new int[]{5, 7, 7, 8, 8, 10}, 5, false));
        System.out.println(m.binarySearch(new int[]{5, 7, 7, 8, 8, 10}, 4, false));
        System.out.println(m.binarySearch(new int[]{5, 7, 7, 8, 8, 10}, 9, false));
        System.out.println(m.binarySearch(new int[]{5, 7, 7, 8, 8, 10}, 10, false));
        System.out.println(m.binarySearch(new int[]{5, 7, 7, 8, 8, 10}, 20, false));
    }
}
