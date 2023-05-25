package com.coding;

import java.util.ArrayList;
import java.util.List;

public class M797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];

        list.add(0);
        dfs(graph, 0, visited, list, ans);
        return ans;
    }

    private void dfs(int[][] graph, int node, boolean[] visited, List<Integer> list, List<List<Integer>> ans) {
        if (visited[node]) {
            return;
        }
        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(list));
            return;
        }

        visited[node] = true;
        for (int i = 0; i < graph[node].length; i++) {
            int n = graph[node][i];
            list.add(n);
            dfs(graph, n, visited, list, ans);
            list.remove(list.size() - 1);
        }
        visited[node] = false;
    }
}
