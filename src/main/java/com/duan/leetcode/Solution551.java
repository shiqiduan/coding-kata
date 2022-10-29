package com.duan.leetcode;

public class Solution551 {
    public boolean checkRecord(String s) {
        if(s == null || s.length() <= 1) {
            return true;
        }
        int absentTimes = 0;
        int coiledLateTime = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(c.equals('A')) {
                absentTimes++;
                if(absentTimes >= 2) {
                    return false;
                }
            }
            if(c.equals('L')) {
                coiledLateTime++;
                if(coiledLateTime >= 3) {
                    return false;
                }
            } else {
                coiledLateTime = 0;
            }
        }
        return true;
    }
}
