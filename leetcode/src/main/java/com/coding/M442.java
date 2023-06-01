package com.coding;

import java.util.ArrayList;
import java.util.List;

public class M442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (v == 0 || v == -1) {
                continue;
            }
            if (nums[v - 1] == -1) {
                ans.add(v);
                nums[i] = 0;
            } else if (nums[v - 1] == 0) {
                nums[v - 1] = -1;
                nums[i] = 0;
            } else {
                if (i == v - 1) {
                    nums[i] = -1;
                } else {
                    nums[i] = nums[v - 1];
                    i--;
                    nums[v - 1] = -1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        M442 m = new M442();

        System.out.println(m.findDuplicates(new int[]{1, 1, 2}));
        System.out.println(m.findDuplicates(new int[]{1}));
        System.out.println(m.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(m.findDuplicates(new int[]{1, 1, 2, 3, 3, 4, 5, 5}));
    }
}
