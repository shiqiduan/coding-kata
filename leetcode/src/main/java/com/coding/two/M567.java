package com.coding.two;

import java.util.Arrays;

public class M567 {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;

        int[] ct1 = new int[26];
        int[] ct2 = new int[26];

        for (int i = 0; i < n; i++) {
            ct1[s1.charAt(i) - 'a']++;
            ct2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(ct1, ct2)) {
            return true;
        }

        for (int i = n; i < m; i++) {
            ct2[s2.charAt(i) - 'a']++;
            ct2[s2.charAt(i - n) - 'a']--;
            if (Arrays.equals(ct1, ct2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        M567 m = new M567();

        System.out.println(m.checkInclusion("adc", "dcda"));
        System.out.println(m.checkInclusion("ab", "eidbaooo"));
        System.out.println(m.checkInclusion("ab", "eidboaooo"));
    }
}
