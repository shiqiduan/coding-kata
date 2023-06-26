package com.coding.two.stack;

import java.util.*;

public class M739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int curr = temperatures[i];
            while (!stack.isEmpty() && curr > temperatures[stack.peek()]) {
                Integer pop = stack.pop();
                ans[pop] = i - pop;
            }
            stack.push(i);
        }
        return ans;
    }

    public int[] dailyTemperatures1(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int curr = temperatures[i];
            while (!stack.isEmpty() && curr >= temperatures[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans.add(0);
            } else {
                ans.add(stack.peek() - i);
            }
            stack.add(i);
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(value -> value).toArray();
    }
}
