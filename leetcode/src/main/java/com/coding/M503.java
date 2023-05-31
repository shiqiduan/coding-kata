package com.coding;

import java.util.Arrays;
import java.util.Stack;

public class M503 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);

        for (int i = 0; i < nums.length * 2 - 1; i++) {
            int index = i % nums.length;
            while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[index];
            }
            stack.push(index);
        }
        return ans;
    }

    public static void main(String[] args) {
        M503 m = new M503();
        System.out.println(Arrays.toString(m.nextGreaterElements(new int[]{1, 2, 3, 4, 5})));
        System.out.println(m.nextGreaterElements(new int[]{1, 2, 1}));
    }
}
