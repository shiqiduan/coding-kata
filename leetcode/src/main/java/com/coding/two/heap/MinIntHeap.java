package com.coding.two.heap;

import java.util.Arrays;

public class MinIntHeap {
    private int capacity = 10;
    private int size = 0;
    private int[] items = new int[capacity];

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int ret = items[0];
        items[0] = items[size - 1];
        size--;
        //
        return ret;
    }

    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]) {
                break;
            }

            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && items[index] < items[parent(index)]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 2) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) <= size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }
}
