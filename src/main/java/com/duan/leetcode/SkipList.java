package com.duan.leetcode;

public class SkipList {

    public String get(String key) {
        return "";
    }

    public String insert(String key, String value) {
        return "";
    }

    public void delete(String key) {

    }

    public class Node {
        private int data = -1;
//        private Node forwards = new Node[];
    }

    private int randomLevel() {
        int level = 1;
        while (Math.random() < 0.25f) {
            level += 1;
        }
        return (level > 15) ? 15 : level;
    }

    public static void main(String[] args) {
        float a = 0.25F;

        System.out.println(a * 0xFFFF);

        SkipList skipList = new SkipList();
        System.out.println(skipList.randomLevel());
        System.out.println(skipList.randomLevel());
        System.out.println(skipList.randomLevel());
        System.out.println(skipList.randomLevel());
        System.out.println(skipList.randomLevel());


    }
}
