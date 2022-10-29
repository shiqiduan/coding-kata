package com.duan.leetcode;

public class S53 {
    public int maxSubArray(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    private int divide(int[] nums, int s, int e) {
        if(s == e) {
            return nums[s];
        }
        if((e - s) == 1) {
            int max = Math.max(nums[s], nums[e]);
            return Math.max(max, nums[s] + nums[e]);
        }
        int mid = s + (e - s)/2;
        int left = divide(nums, s, mid - 1);
        int right = divide(nums, mid + 1, e);

        int tempmax = nums[mid];
        int sum = nums[mid];
        for (int i = mid - 1; i >= s; i--) {
            sum += nums[i];
            if(sum > tempmax) {
                tempmax = sum;
            }
        }
        sum = tempmax;
        for (int i = mid + 1; i <= e ; i++) {
            sum += nums[i];
            if(sum > tempmax) {
                tempmax = sum;
            }
        }

        int max = Math.max(left, right);
        return Math.max(max, tempmax);
    }

    public static void main(String[] args) {
        S53 s = new S53();
        System.out.println(s.maxSubArray(new int[] {5,4}));
        System.out.println(s.maxSubArray(new int[] {5,4, -1}));
        System.out.println(s.maxSubArray(new int[] {5,4, -1, 7,8}));
        System.out.println(s.maxSubArray(new int[] {-2, -1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
