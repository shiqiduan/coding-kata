package com.coding;

import java.util.Stack;

public class E232 {

}

class MyQueue {

    private final Stack<Integer> data = new Stack<Integer>();
    private final Stack<Integer> temp = new Stack<Integer>();

    public MyQueue() {

    }

    public void push(int x) {
        data.push(x);
    }

    public int pop() {
        while (!data.isEmpty()) {
            temp.push(data.pop());
        }
        int x = temp.pop();
        while (!temp.isEmpty()) {
            data.push(temp.pop());
        }
        return x;
    }

    public int peek() {
        while (!data.isEmpty()) {
            temp.push(data.pop());
        }
        int x = temp.peek();
        while (!temp.isEmpty()) {
            data.push(temp.pop());
        }
        return x;
    }

    public boolean empty() {
        return data.isEmpty();
    }
}
