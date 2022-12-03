package com.duan.leetcode;

import org.junit.Assert;

/**
 * 这个问题卡住了。基本假设，如果碰到不相等的情况，则删除一个字符，剩下的是一个回文串（可解）.
 * 卡在了什么地方？描述清楚问题，基本就可解了。
 */
public class E680 {
    public boolean validPalindrome(String s) {
        int a = 0, b = s.length() - 1, count = 0;
        while (a < b) {
            if (s.charAt(a) != s.charAt(b)) {
                return isValid(s, a + 1, b) || isValid(s, a, b - 1);
            }
            a++;
            b--;
        }
        return true;
    }

    private boolean isValid(String s, int a, int b) {
        while (a < b) {
            if (s.charAt(a) != s.charAt(b)) {
                return false;
            }
            a++;
            b--;
        }
        return true;
    }

    public static void main(String[] args) {
        E680 e = new E680();

        Assert.assertTrue(e.validPalindrome("aba"));
        Assert.assertTrue(e.validPalindrome("ab"));
        Assert.assertTrue(e.validPalindrome("abca"));
        Assert.assertFalse(e.validPalindrome("abc"));
        Assert.assertTrue(e.validPalindrome("abcba"));
        Assert.assertTrue(e.validPalindrome("abcdba"));
        Assert.assertFalse(e.validPalindrome("abcdeba"));
        Assert.assertTrue(e.validPalindrome("cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuc"));
        Assert.assertTrue(e.validPalindrome("cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu"));
    }
}
