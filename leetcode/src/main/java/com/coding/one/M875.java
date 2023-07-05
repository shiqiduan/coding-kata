package com.coding.one;

public class M875 {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        int s = 1, e = max;
        int ans = max;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (eatTime(piles, mid, h) <= h) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    private int eatTime(int[] piles, int k, int h) {
        int ans = 0;
        for (int i = 0; i < piles.length; i++) {
            int x = piles[i];
            // ans += x / k + ((x % k) > 0 ? 1 : 0);
            ans += (x + k - 1) / k;
        }
        return ans;
    }

    public static void main(String[] args) {
        M875 m = new M875();

        System.out.println(m.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }
}
