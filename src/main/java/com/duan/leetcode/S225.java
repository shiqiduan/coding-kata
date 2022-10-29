package com.duan.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class S225 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}

class MyStack {
    private Queue<Integer> one;
    private Queue<Integer> two;

    public MyStack() {
        one = new ArrayDeque<>();
        two = new ArrayDeque<>();
    }

    public void push(int x) {
        if (!two.isEmpty()) {
            two.add(x);
            return;
        }
        one.add(x);
    }

    public int pop() {
        checkQueue();
        return pop(one, two);
    }

    public void checkQueue() {
        if (empty()) {
            throw new RuntimeException();
        }
        Queue<Integer> temp = one;
        if(one.isEmpty()) {
            one = two;
            two = temp;
        }
    }

    private Integer pop(Queue<Integer> dataQueue, Queue<Integer> emptyQueue) {
        int size = dataQueue.size() - 1;
        for (int i = 0; i < size; i++) {
            emptyQueue.add(dataQueue.poll());
        }
        return dataQueue.poll();
    }

    public int top() {
        checkQueue();
        int ret = pop(one, two);
        two.add(ret);
        return ret;
    }

    public boolean empty() {
        return one.isEmpty() && two.isEmpty();
    }
}
