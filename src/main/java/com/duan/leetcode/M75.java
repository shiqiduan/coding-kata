package com.duan.leetcode;

import java.util.Arrays;

public class M75 {
    public void sortColors(int[] nums) {
        if(nums.length == 1) return;
        int n0 = 0, n2 = nums.length - 1;
        int current = 0;

        while (current <= n2) {
            if(nums[current] == 0) {
                if(current == n0) {
                    current++;
                    n0++;
                } else {
                    swap(nums, current, n0);
                    n0++;
                }
                continue;
            }
            if(nums[current] == 2) {
                if(current == n2) {
                    return;
                } else {
                    swap(nums, current, n2);
                    n2--;
                }
                continue;
            }
            current++;
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        M75 m = new M75();
        print(new int[]{2, 0, 1}, m);
        print(new int[]{2, 0, 2, 1, 1, 0}, m);
        print(new int[]{2}, m);
        print(new int[]{2, 2}, m);
        print(new int[]{1, 1}, m);
    }

    private static void print(int[] a, M75 m) {
        m.sortColors(a);
        System.out.println(Arrays.toString(a));
    }
}
