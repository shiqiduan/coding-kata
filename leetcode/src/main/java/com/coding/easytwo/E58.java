package com.coding.easytwo;

import java.util.Arrays;

public class E58 {

    /**
     * 从后开始遍历
     */
    public int lengthOfLastWord(String s) {
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (ans == 0) {
                    continue;
                } else {
                    break;
                }
            }
            ans++;
        }
        return ans;
    }


    public int lengthOfLastWord1(String s) {
        String[] split = s.split("\\s+");
        int ans = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() != 0) {
                ans = split[i].length();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString("   fly me   to   the moon  ".split("\\s+")));
        System.out.println(Arrays.toString("fly me   to   the moon  ".split("\\s+")));
        System.out.println(Arrays.toString("  ".split("\\s+")));
        System.out.println(Arrays.toString("  a b c    d ".split("\\s+")));
    }
}
