package com.coding;

import java.util.ArrayList;
import java.util.List;

public class M93 {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4) return new ArrayList<>();
        if (s.length() > 12) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        track(s, 0, 0, list, ans);
        return ans;
    }

    private int getIPSegment(String s, int x, int y) {
        int len = y - x + 1;
        if (s.charAt(x) == '0') {
            return len == 1 ? 0 : -1;
        }
        int num = Integer.parseInt(s.substring(x, y + 1));
        return num <= 255 ? num : -1;
    }

    private void track(String s, int index, int count, List<Integer> list, List<String> ans) {
        if (count == 4 && index == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : list) {
                sb.append(i).append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            ans.add(sb.toString());
            return;
        }

        if (index >= s.length()) {
            return;
        }

        for (int i = index; i < index + 3; i++) {
            int ipSegment = -1;
            if (i >= s.length()) {
                ipSegment = getIPSegment(s, index, s.length() - 1);
            } else {
                ipSegment = getIPSegment(s, index, i);
            }
            if (ipSegment > -1) {
                list.add(ipSegment);
                track(s, i + 1, count + 1, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }
}
