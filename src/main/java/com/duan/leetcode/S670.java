package com.duan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class S670 {
    public int maximumSwap(int num) {
        char[] array = (num + "").toCharArray();
        if(array.length == 1) return num;

        // 当前位置的最大值所在的位置
        Map<Integer, Integer> maxMap = new HashMap<>();

        int maxIndex = array.length - 1;
        int max = array[maxIndex];
        int swapFrom = maxIndex;
        int swapTo = maxIndex;
        for(int i = array.length - 1; i >= 0; i--) {
            if(array[i] >= max) {
                max = array[i];
                maxIndex = i;
            }
            maxMap.put(i, maxIndex);
            if(maxIndex != i && array[i] != max) {
                swapFrom = i;
                swapTo = maxIndex;
            }
        }

        char temp = array[swapFrom];
        array[swapFrom] = array[swapTo];
        array[swapTo] = temp;

        return Integer.parseInt(new String(array));
    }

    public static void main(String[] args) {
        S670 s = new S670();

        System.out.println(s.maximumSwap(4567890));
    }
}
