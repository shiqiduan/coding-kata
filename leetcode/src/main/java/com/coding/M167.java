package com.coding;

import java.util.Arrays;

public class M167 {
    public int[] twoSum(int[] numbers, int target) {
        int s = 1, e = numbers.length;
        while (s < e) {
            int sum = numbers[s - 1] + numbers[e - 1];
            if (sum == target) {
                return new int[]{s, e};
            } else if (sum < target) {
                s++;
            } else {
                e--;
            }
        }
        return new int[]{s, e};
    }

    public static void main(String[] args) {
        M167 m = new M167();
        System.out.println(Arrays.toString(m.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(m.twoSum(new int[]{2, 3, 4}, 6)));
    }
}
