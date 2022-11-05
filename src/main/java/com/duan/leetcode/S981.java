package com.duan.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class S981 {

    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(7, "7");
        treeMap.put(1, "1");
        treeMap.put(3, "3");
        treeMap.put(5, "5");

        System.out.println("firstKey " + treeMap.firstKey());
        System.out.println("firstKey " + treeMap.firstKey());
        System.out.println("lastKey " + treeMap.lastKey());

        System.out.println(treeMap.lowerKey(10));
        System.out.println(treeMap.lowerKey(1));
    }

}

class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> tree = map.getOrDefault(key, new TreeMap<>());
        tree.put(timestamp, value);
        map.put(key, tree);
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }

        TreeMap<Integer, String> tree = map.get(key);

        if(tree.containsKey(timestamp)) {
            return tree.get(timestamp);
        }

        Integer integer = tree.lowerKey(timestamp);

        return (integer == null) ? "": tree.get(integer);
    }
}
