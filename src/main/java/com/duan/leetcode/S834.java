//package com.duan.leetcode;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class S834 {
//    int[] ans;
//    int[] sz;
//    int[] dp;
//    List<List<Integer>> graph;
//
//    public int[] sumOFDITree(int n, int[][] edges) {
//        ans = new int[n];
//        sz = new int[n];
//        dp = new int[n];
//
//        graph = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            graph.add(new ArrayList<>());
//        }
//        for(int[] edge: edges) {
//            int u = edge[0], v = edge[1];
//            graph.get(u).add(v);
//            graph.get(v).add(u);
//        }
//        dfs(0, -1);
//    }
//
//    public void dfs(int u, int f) {
//        sz[u] = 1;
//        dp[u] = 0;
//        for (int v : graph.get(u)) {
//            if(v == f) {
//                continue;
//            }
//            dfs(v, u);
//        }
//    }
//}
