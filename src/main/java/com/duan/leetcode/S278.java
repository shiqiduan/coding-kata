package com.duan.leetcode;

public class S278 {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)) {
                if(mid == 1) {
                    return 1;
                }
                if(!isBadVersion(mid - 1)) {
                    return mid;
                }
                end = mid - 1;
            } else {
                if(isBadVersion(mid + 1)) {
                    return mid + 1;
                }
                start = start + 1;
            }
        }
        return -1;
    }

    private boolean isBadVersion(int x) {
        return 1 == x;
    }
}
