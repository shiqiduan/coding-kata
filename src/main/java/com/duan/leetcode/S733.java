package com.duan.leetcode;

public class S733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        track(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private void track(int[][] image, int sr, int sc, int color, int equalColor) {
        if(sr < 0 || sr >= image.length) {
            return;
        }
        if(sc < 0 || sc >= image[0].length) {
            return;
        }
        if(image[sr][sc] == color) {
            return;
        }
        if(image[sr][sc] != equalColor) {
            return;
        }

        image[sr][sc] = color;

        track(image, sr - 1, sc, color, equalColor);
        track(image, sr + 1, sc, color, equalColor);
        track(image, sr, sc - 1, color, equalColor);
        track(image, sr, sc + 1, color, equalColor);
    }
}
