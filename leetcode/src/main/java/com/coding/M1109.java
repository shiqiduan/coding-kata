package com.coding;

import java.util.Arrays;

public class M1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] d = new int[n + 1];

        for (int i = 0; i < bookings.length; i++) {
            int a = bookings[i][0], b = bookings[i][1], c = bookings[i][2];
            d[a - 1] += c;
            d[b] -= c;
        }

        System.out.println(Arrays.toString(d));

        int sum = 0;
        int[] ans = new int[n];
        for (int i = 0; i < d.length - 2; i++) {
            sum += d[i];
            ans[i] = sum;
        }
        return ans;
    }
}
