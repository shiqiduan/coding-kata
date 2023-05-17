package com.coding;

public class M12 {
    int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] strs = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (num >= x) {
                num -= x;
                sb.append(strs[i]);
                i--;
            }
            if (num == 0) {
                break;
            }
        }
        return sb.toString();
    }
}
