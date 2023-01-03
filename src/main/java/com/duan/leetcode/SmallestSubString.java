package com.duan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubString {
    static String getShortestSubString(char[] arr, String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i])) {
                return "";
            }
        }
        String a = getString(arr, str, map, true);
        String b = getString(arr, str, map, false);
        if(a == "") return b;
        if(b == "") return a;
        return (a.length() > b.length()) ? b : a;
    }

    private static String getString(char[] arr, String str, Map<Character, Integer> map, boolean fromLeft) {
        Map<Character, Integer> tempMap = new HashMap<>();
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }

        int start = 0, end = str.length() - 1;
        while ((end - start) >= (arr.length)) {
            if(fromLeft) {
                char startChar = str.charAt(start);
                if(map.get(startChar) > 1) {
                    map.put(startChar, map.get(startChar) - 1);
                    start++;
                    continue;
                }
                char endChar = str.charAt(end);
                if(map.get(endChar) > 1) {
                    map.put(endChar, map.get(endChar) - 1);
                    end--;
                    continue;
                }
            } else {
                char endChar = str.charAt(end);
                if(map.get(endChar) > 1) {
                    map.put(endChar, map.get(endChar) - 1);
                    end--;
                    continue;
                }
                char startChar = str.charAt(start);
                if(map.get(startChar) > 1) {
                    map.put(startChar, map.get(startChar) - 1);
                    start++;
                    continue;
                }
            }
            break;
        }
        return str.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(SmallestSubString.getShortestSubString(new char[]{'x', 'y', 'z'}, "xyyzyzyx"));
        System.out.println(SmallestSubString.getShortestSubString(new char[]{'x', 'y', 'z'}, "xyzzzzzyx"));
        System.out.println(SmallestSubString.getShortestSubString(new char[]{'x', 'y', 'z'}, "xyyyyyyy"));
    }
}
