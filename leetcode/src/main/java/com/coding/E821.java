package com.coding;

import org.junit.Assert;

import java.util.Arrays;

public class E821 {
    public int[] shortestToChar(String s, char c) {
        int[] ret = new int[s.length()];
        Arrays.fill(ret, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) != c) {
                i++;
                continue;
            }
            ret[i] = 0;
            int j = i - 1;
            while (j >= 0 && s.charAt(j) != c && ret[j] > Math.abs(i - j)) {
                ret[j] = Math.abs(i - j);
                j--;
            }
            j = i + 1;
            while (j < s.length() && s.charAt(j) != c) {
                ret[j] = Math.abs(j - i);
                j++;
            }
            i = j;
        }
        return ret;
    }

    public void testShortestToChar() {
        Assert.assertArrayEquals(new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}, shortestToChar("loveleetcode", 'e'));
    }

    public static void main(String[] args) {
        E821 e821 = new E821();
        e821.testShortestToChar();
    }
}
