package com.coding;

import java.util.ArrayList;
import java.util.List;

public class E125 {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        StringBuilder sb2 = new StringBuilder(sb).reverse();
        return sb.toString().equals(sb2.toString());
    }


    public boolean isPalindrome1(String s) {
        List<Character> list = new ArrayList<Character>();
        for (Character c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                list.add(Character.toLowerCase(c));
            }
            if (Character.isLowerCase(c)) {
                list.add(c);
            }
            if (Character.isDigit(c)) {
                list.add(c);
            }
        }
        if (list.isEmpty()) return true;
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (!list.get(l).equals(list.get(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        E125 e = new E125();

        System.out.println(e.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
