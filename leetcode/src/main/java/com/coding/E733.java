package com.coding;

public class E733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, -1, image[sr][sc]);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (image[i][j] == -1) {
                    image[i][j] = color;
                }
            }
        }
        return image;
    }

    private void dfs(int[][] images, int a, int b, int color, int value) {
        if (a < 0 || a >= images.length || b < 0 || b >= images[0].length) {
            return;
        }
        
        if (images[a][b] != value) {
            return;
        }

        images[a][b] = color;
        dfs(images, a + 1, b, color, value);
        dfs(images, a - 1, b, color, value);
        dfs(images, a, b + 1, color, value);
        dfs(images, a, b - 1, color, value);
    }

    public static void main(String[] args) {
        E733 e = new E733();
        int[][] array = {
                {0, 0, 0},
                {0, 0, 0}
        };
        e.floodFill(array, 1, 0, 2);
    }
}
