package com.coding.one;

public class M622 {
    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(4));
    }
}

class MyCircularQueue {
    private final int[] array;
    private int fontIndex = -1, rearIndex = -1;
    private final int capacity;

    public MyCircularQueue(int k) {
        this.array = new int[k];
        this.capacity = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            fontIndex = 0;
            rearIndex = -1;
        }
        rearIndex = (rearIndex + 1) % this.capacity;
        array[rearIndex] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (fontIndex == rearIndex) {
            fontIndex = rearIndex = -1;
        } else {
            fontIndex = (fontIndex + 1) % this.capacity;
        }
        return true;
    }

    public int Front() {
        return (isEmpty()) ? -1 : array[fontIndex];
    }

    public int Rear() {
        return (isEmpty()) ? -1 : array[rearIndex];
    }

    public boolean isEmpty() {
        return rearIndex == -1;
    }

    public boolean isFull() {
        return ((rearIndex + 1) % this.capacity) == fontIndex;
    }
}