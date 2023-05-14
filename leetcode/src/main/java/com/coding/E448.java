package com.coding;

import java.util.ArrayList;
import java.util.List;

/**
 * 30 minutes
 */
public class E448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - 1) % size;
            nums[index] += size;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= size) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        E448 e = new E448();

        System.out.println(e.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
