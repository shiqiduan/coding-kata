package com.coding.two;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class E268 {
    public int missingNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        for (int i = 0; i <= nums.length; i++) {
            ans ^= i;
        }
        return ans;
    }

    public int missingNumber3(int[] nums) {
        int x = nums[0];
        for (int i = 1; i < nums.length; i++) {
            x ^= nums[i];
        }
        for (int i = 0; i <= nums.length; i++) {
            x ^= i;
        }
        return x;
    }

    public int missingNumber2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return i;
    }
}
