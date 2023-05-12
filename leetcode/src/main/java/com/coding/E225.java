package com.coding;

import java.util.ArrayDeque;
import java.util.Queue;

public class E225 {
}

class MyStack {
    private Queue<Integer> data;
    private Queue<Integer> empty;

    public MyStack() {
        data = new ArrayDeque<>();
        empty = new ArrayDeque<>();
    }

    public void push(int x) {
        data.offer(x);
    }

    public int pop() {
        if (data.size() == 1) {
            return data.poll();
        }
        for (int i = 0; i < data.size() - 1; i++) {
            empty.add(data.poll());
        }
        int x = data.poll();
        Queue<Integer> temp = data;
        data = empty;
        empty = temp;
        return x;
    }

    public int top() {
        if (data.size() == 1) {
            return data.peek();
        }
        int size = data.size() - 1;
        for (int i = 0; i < size; i++) {
            empty.offer(data.poll());
        }
        int x = data.poll();
        empty.offer(x);
        Queue<Integer> temp = data;
        data = empty;
        empty = temp;
        return x;
    }

    public boolean empty() {
        return data.isEmpty() && empty.isEmpty();
    }
}