package com.coding;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class E496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < nums2.length; ) {
            if (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            } else {
                stack.push(nums2[i]);
                i++;
            }
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        int[] ret = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ret[i] = map.get(nums1[i]);
        }
        return ret;
    }
}
