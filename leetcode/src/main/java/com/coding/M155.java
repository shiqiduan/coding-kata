package com.coding;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M155 {
}

class MinStack {
    private Stack<Integer> stack;
    private List<Integer> minList;

    public MinStack() {
        stack = new Stack<>();
        minList = new ArrayList<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minList.isEmpty()) {
            minList.add(val);
        } else {
            minList.add(Math.min(minList.get(minList.size() - 1), val));
        }
    }

    public void pop() {
        stack.pop();
        minList.remove(minList.size() - 1);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minList.get(minList.size() - 1);
    }
}
