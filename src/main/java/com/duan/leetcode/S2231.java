package com.duan.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S2231 {
    public int largestInteger(int num) {
        if(num <= 10) return num;
        String numStr = num + "";
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();
        for (int i = 0; i < numStr.length(); i++) {
            int n = (int) numStr.charAt(i) - 48;
            if(n % 2 == 0) {
                evenList.add(n);
            } else {
                oddList.add(n);
            }
        }
        Collections.sort(evenList);
        Collections.sort(oddList);

        StringBuilder retStr = new StringBuilder();
        for (int i = 0; i < numStr.length(); i++) {
            int n = (int) numStr.charAt(i) - 48;
            if(n % 2 == 0) {
                retStr.append(evenList.get(evenList.size() - 1));
                evenList.remove(evenList.size() - 1);
            } else {
                retStr.append(oddList.get(oddList.size() - 1));
                oddList.remove(oddList.size() - 1);
            }
        }
        return Integer.parseInt(retStr.toString());
    }

    public static void main(String[] args) {
        S2231 s = new S2231();
        System.out.println(s.largestInteger(1234));
        System.out.println(s.largestInteger(65875));
    }
}
