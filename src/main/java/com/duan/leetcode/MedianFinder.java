package com.duan.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> one;
    private PriorityQueue<Integer> two;
    private int size;

    public MedianFinder() {
        one = new PriorityQueue<>(Comparator.reverseOrder());
        two = new PriorityQueue<>();
    }

    public void addNum(int num) {
        size++;
        if (one.isEmpty()) {
            one.add(num);
            return;
        }
        if (num <= one.peek()) {
            one.add(num);
        } else {
            two.add(num);
        }
        while (one.size() > two.size() + 1) {
            two.add(one.poll());
        }
        while (one.size() < two.size()) {
            one.add(two.poll());
        }
    }

    public double findMedian() {
        if(size % 2 == 0) {
            return (one.peek() + two.peek()) / 2.0;
        } else {
            return one.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        for (int i = 0; i < 4; i++) {
            finder.addNum(i);
        }
        System.out.println(finder.findMedian());
    }
}
