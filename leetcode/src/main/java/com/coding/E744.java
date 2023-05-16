package com.coding;

public class E744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int s = 0, e = letters.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (letters[mid] == target) {
                s++;
            } else if (letters[mid] < target) {
                s++;
            } else {
                e--;
            }
        }
        return (s >= letters.length) ? letters[0] : letters[s];
    }
}
