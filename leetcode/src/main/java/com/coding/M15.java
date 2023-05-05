package com.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            int left = i + 1;
            int right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;
                    while (left < nums.length && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        M15 m = new M15();
        System.out.println(m.threeSum(new int[]{0, 1, 1}));
        System.out.println(m.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(m.threeSum(new int[]{0, 0, 0}));
    }
}
