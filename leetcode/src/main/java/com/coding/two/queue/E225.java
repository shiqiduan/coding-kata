package com.coding.two.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class E225 {
}

class MyStack {
    private Deque<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.addLast(x);
    }

    public int pop() {
        int size = queue.size();
        while (size > 1) {
            queue.addLast(queue.pollFirst());
            size--;
        }
        return queue.pollFirst();
    }

    public int top() {
        int pop = pop();
        queue.addLast(pop);
        return pop;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
