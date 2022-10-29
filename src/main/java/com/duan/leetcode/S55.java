package com.duan.leetcode;


public class S55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int rightmost = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i > rightmost) {
                return false;
            }
            rightmost = Math.max(rightmost, i + nums[i]);
            if(rightmost >= (len - 1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        S55 s = new S55();

        s.canJump(new int[] {3,2,1,0,4});
    }
}
