package com.coding.two.queue;

import java.util.Stack;

public class E232 {

}

class MyQueue {
    private final Stack<Integer> queue;
    private final Stack<Integer> stack;

    public MyQueue() {
        queue = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        if (!queue.isEmpty()) {
            return queue.pop();
        }
        while (!stack.isEmpty()) {
            queue.push(stack.pop());
        }
        return queue.pop();
    }

    public int peek() {
        if (!queue.isEmpty()) {
            return queue.peek();
        }
        while (!stack.isEmpty()) {
            queue.push(stack.pop());
        }
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty() && stack.isEmpty();
    }
}
