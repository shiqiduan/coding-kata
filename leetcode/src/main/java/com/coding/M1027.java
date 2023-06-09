package com.coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class M1027 {
    public int longestArithSeqLength(int[] nums) {
        int ans = 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int d = nums[i] - nums[j];

                int x = map.getOrDefault(j, new HashMap<>()).getOrDefault(d, 1);

                Map<Integer, Integer> temp = map.getOrDefault(i, new HashMap<>());
                temp.put(d, Math.max(x + 1, temp.getOrDefault(d, 0)));
                map.put(i, temp);

                ans = Math.max(ans, temp.getOrDefault(d, 1));
            }
        }
        return ans;
    }

    public int longestArithSeqLength1(int[] nums) {
        int maxV = Arrays.stream(nums).max().getAsInt();
        int minV = Arrays.stream(nums).min().getAsInt();
        int ans = 1;
        int diff = maxV - minV;
        for (int d = -diff; d <= diff; d++) {
            int[] f = new int[maxV + 1];
            Arrays.fill(f, -1);
            for (int i = 0; i < nums.length; i++) {
                int x = nums[i] - d;
                if (x >= minV && x <= maxV && f[x] != -1) {
                    f[nums[i]] = Math.max(f[nums[i]], f[x] + 1);
                    ans = Math.max(ans, f[nums[i]]);
                }
                f[nums[i]] = Math.max(f[nums[i]], 1);
            }
        }
        return ans;
    }
}
