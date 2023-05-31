package com.coding;

import java.util.ArrayList;
import java.util.List;

public class M547 {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int ans = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i]) {
                continue;
            }
            ans++;
            track(i, isConnected, visited);
        }
        return ans;
    }

    private void track(int x, int[][] isConnected, boolean[] visited) {
        List<Integer> nodes = new ArrayList<>();
        nodes.add(x);
        while (!nodes.isEmpty()) {
            List<Integer> newNodes = new ArrayList<>();
            for (int i = 0; i < nodes.size(); i++) {
                int n = nodes.get(i);
                if (visited[n]) {
                    continue;
                }
                visited[n] = true;

                for (int j = 0; j < isConnected[n].length; j++) {
                    if (isConnected[n][j] == 1 && !visited[j]) {
                        newNodes.add(j);
                    }
                }
            }
            nodes = newNodes;
        }
    }
}
