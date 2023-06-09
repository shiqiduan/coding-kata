package com.coding.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class E989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int a = num.length - 1, carry = 0;
        while (a >= 0 || k > 0) {
            int av = (a >= 0) ? num[a] : 0;
            int kv = k % 10;
            k = k / 10;
            int c = av + kv + carry;
            ans.add(c % 10);
            carry = c / 10;
            a--;
        }
        if (carry > 0) {
            ans.add(carry);
        }
        Collections.reverse(ans);
        return ans;
    }
}
