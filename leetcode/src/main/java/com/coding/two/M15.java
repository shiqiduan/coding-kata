package com.coding.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int e = nums.length - 1;
            int s = i + 1;

            while (s < e) {
                int sum = nums[i] + nums[s] + nums[e];
                if (sum == 0) {
                    ans.add(List.of(nums[i], nums[s], nums[e]));
                    while (s < e && nums[s] == nums[s + 1]) {
                        s++;
                    }
                    while (e > s && nums[e] == nums[e - 1]) {
                        e--;
                    }
                    s++;
                    e--;
                } else if (sum > 0) {
                    e--;
                } else {
                    s++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        M15 m = new M15();
        System.out.println(m.threeSum(new int[]{0, 1, 1}));
        System.out.println(m.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(m.threeSum(new int[]{0, 0, 0}));
    }
}
