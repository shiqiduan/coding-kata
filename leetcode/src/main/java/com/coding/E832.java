package com.coding;

public class E832 {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int a = 0, b = image[0].length - 1;
            while (a < b) {
                int temp = image[i][a];
                image[i][a] = image[i][b] ^ 1;
                image[i][b] = temp ^ 1;
                a++;
                b--;
            }
            if (a == b) {
                image[i][a] = image[i][a] ^ 1;
            }
        }
        return image;
    }

    public static void main(String[] args) {
        System.out.println(1 ^ 1);
        System.out.println(0 ^ 1);
        System.out.println(~1);
        System.out.println(~0);
        System.out.println(~5);
    }
}
