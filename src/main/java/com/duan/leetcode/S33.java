package com.duan.leetcode;

import java.util.Arrays;

public class S33 {
    public int search(int[] nums, int target) {
        int k = 0;
        if(nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                if(nums[i] < nums[i - 1]) {
                    k = i;
                }
            }
        }
        int start = 0, end = nums.length - 1;
        if(k == 0) {
            if(!(target >= nums[0] && target <= nums[nums.length - 1])) {
                return -1;
            }
        } else {
            if(target >= nums[k] && target <= nums[nums.length - 1]) {
                start = k;
            } else if(target >= nums[0] && target <= nums[k - 1]) {
                end = k - 1;
            } else {
                return  -1;
            }
        }

        int i = Arrays.binarySearch(nums, start, end + 1, target);
        return (i < 0) ? -1 : i;
    }

    public static void main(String[] args) {
        S33 s = new S33();
        System.out.println(s.search(new int[] {4,5,6,7,0,1,2}, 0));
        System.out.println(s.search(new int[] {4,5,6,7,0,1,2}, 3));
        System.out.println(s.search(new int[] {1}, 0));
        System.out.println(s.search(new int[] {1}, 1));
        System.out.println(s.search(new int[] {1}, 2));
        System.out.println(s.search(new int[] {1,2,3}, 2));
        System.out.println(s.search(new int[] {1,2,3}, 3));
        System.out.println(s.search(new int[] {1,2,3}, 4));
    }
}
