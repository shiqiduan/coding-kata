package com.coding;

public class M151 {
    public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].trim().length() > 0) {
                sb.append(split[i]).append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
