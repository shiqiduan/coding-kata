package com.coding.two.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class M155 {
}

class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> min;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.min = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);

        if (!min.isEmpty() && val >= min.peek()) {
            min.push(min.peek());
        } else {
            min.push(val);
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
