package com.duan.leetcode;

public class E706 {
}

class MyHashMap {
    private final NodeValue[] table;
    private final int capacity;

    public MyHashMap() {
        this.capacity = 100;
        this.table = new NodeValue[capacity];
    }

    public void put(int key, int value) {
        NodeValue node = table[getIndex(key)];
        if (node == null) {
            table[getIndex(key)] = new NodeValue(key, value, null);
            return;
        }
        while (node != null) {
            if (node.key == key) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        table[getIndex(key)] = new NodeValue(key, value, table[getIndex(key)]);
    }

    public int get(int key) {
        NodeValue node = table[getIndex(key)];
        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        NodeValue node = table[getIndex(key)];
        if (node == null) return;
        if (node.key == key) {
            table[getIndex(key)] = node.next;
            return;
        }
        NodeValue prev = node;
        NodeValue current = node.next;
        while (current != null) {
            if (current.key == key) {
                prev.next = current.next;
                return;
            }
            prev = prev.next;
            current = current.next;
        }
    }

    private int getIndex(int key) {
        return key % capacity;
    }
}

class NodeValue {
    public Integer key;
    public Integer value;
    public NodeValue next;

    public NodeValue(int key, int value, NodeValue next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
