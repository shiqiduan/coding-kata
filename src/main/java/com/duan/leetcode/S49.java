package com.duan.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] keyArr = new int[26];
            String item = strs[i];
            for (int j = 0; j < item.length(); j++) {
                int index = item.charAt(j) - 'a';
                keyArr[index]++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if(keyArr[j] > 0) {
                    sb.append(new Character((char) ('a' + j)));
                    sb.append(keyArr[j]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(strs[i]);
            map.put(key, list);
        }
        List<List<String>> ret = new ArrayList<>();
        ret.addAll(map.values());
        return ret;
    }
}
