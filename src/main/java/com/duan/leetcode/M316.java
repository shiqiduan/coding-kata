package com.duan.leetcode;

public class M316 {
    public String removeDuplicateLetters(String s) {
        boolean[] contained = new boolean[26];
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!contained[c - 'a']) {
                for (int j = sb.length() - 1; j >= 0; j--) {
                    char ac = sb.charAt(j);
                    if(c <= ac && nums[ac - 'a'] >= 1) {
                        sb.deleteCharAt(j);
                        contained[ac - 'a'] = false;
                    } else {
                        break;
                    }
                }
                sb.append(c);
                contained[c - 'a'] = true;
            }
            nums[c - 'a']--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        M316 m = new M316();
        System.out.println(m.removeDuplicateLetters("bcabc"));
        System.out.println(m.removeDuplicateLetters("abcba"));
        System.out.println(m.removeDuplicateLetters("cbacdcbc"));
        System.out.println(m.removeDuplicateLetters("c"));
        System.out.println(m.removeDuplicateLetters("cb"));
        System.out.println(m.removeDuplicateLetters("cbc"));
        System.out.println(m.removeDuplicateLetters("bcb"));
        System.out.println(m.removeDuplicateLetters("bbbbba"));
        System.out.println(m.removeDuplicateLetters("abacb"));
        System.out.println(m.removeDuplicateLetters("acabc"));
        System.out.println(m.removeDuplicateLetters("bbcaac"));
    }
}
