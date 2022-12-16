package com.duan.leetcode;

import org.junit.Assert;

public class E860 {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0, count10 = 0;
        for (int i = 0; i < bills.length; i++) {
            int num = bills[i];
            switch (num) {
                case 5:
                    count5++;
                    break;
                case 10:
                    if (count5 >= 1) {
                        count5--;
                        count10++;
                    } else {
                        return false;
                    }
                    break;
                case 20:
                    if (count10 > 0) {
                        count10--;
                        if (count5 > 0) {
                            count5--;
                        } else {
                            return false;
                        }
                    } else {
                        if (count5 >= 3) {
                            count5 -= 3;
                        } else {
                            return false;
                        }
                    }
                    break;
                default:
            }
        }
        return true;
    }

    public static void main(String[] args) {
        E860 e = new E860();

        Assert.assertTrue(e.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        Assert.assertFalse(e.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    }
}
