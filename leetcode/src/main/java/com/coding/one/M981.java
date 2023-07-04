package com.coding.one;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class M981 {

    static class TimeMap {
        Map<String, TreeMap<Integer, String>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            TreeMap<Integer, String> valMap = map.getOrDefault(key, new TreeMap<>());
            valMap.put(timestamp, value);
            map.put(key, valMap);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> treeMap = map.get(key);
            if (treeMap == null) {
                return "";
            }
            Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
            return (entry == null) ? "" : entry.getValue();
        }

    }

    public static void main(String[] args) {
        TimeMap map = new TimeMap();
        map.set("foo", "bar", 1);
        System.out.println(map.get("foo", 1));
        System.out.println(map.get("foo", 3));
        map.set("foo", "bar2", 4);
        System.out.println(map.get("foo", 4));
        System.out.println(map.get("foo", 5));
    }
}
