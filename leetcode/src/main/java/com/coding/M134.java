package com.coding;

public class M134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int all = 0;
            for (int j = 0; j <= gas.length; j++) {
                int index = (i + j) % gas.length;
                all = all + gas[index] - cost[index];
                if (all < 0) {
                    i = i + j;
                    break;
                }
            }
            if (all >= 0) {
                return i;
            }
        }
        return -1;
    }
}
