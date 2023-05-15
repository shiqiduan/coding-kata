package com.coding;

public class E1047 {
    public String removeDuplicates(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (sb.length() >= 1 && s.charAt(i) == sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        E1047 e = new E1047();

        System.out.println(e.removeDuplicates("abbaca"));
    }
}
