package com.duan.leetcode;

import java.util.ArrayList;
import java.util.List;

public class S155 {

}

class MinStack {
    private List<Integer> stack;
    private List<Integer> minList;

    public MinStack() {
        this.stack = new ArrayList<>();
        this.minList = new ArrayList<>();
    }

    public void push(int val) {
        this.stack.add(val);
        if(minList.isEmpty()) {
            minList.add(val);
        } else {
            minList.add(Math.min(val, minList.get(minList.size() - 1)));
        }
    }

    public void pop() {
        if(!stack.isEmpty()) {
            stack.remove(stack.size() - 1);
            minList.remove(minList.size() - 1);
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return minList.get(minList.size() - 1);
    }
}
