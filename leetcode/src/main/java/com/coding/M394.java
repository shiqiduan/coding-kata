package com.coding;

public class M394 {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int times = 0;
        StringBuilder temp = new StringBuilder();
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c) && flag == 0) {
                times = times * 10 + Character.getNumericValue(c);
                continue;
            }
            if (c == '[') {
                flag++;
                if (flag == 1) {
                    temp = new StringBuilder();
                    continue;
                }
            }
            if (c == ']') {
                flag--;
                if (flag != 0) {
                    temp.append(c);
                    continue;
                }
                String t = decodeString(temp.toString());
                for (int j = 0; j < times; j++) {
                    sb.append(t);
                }
                times = 0;
                continue;
            }
            if (times == 0) {
                sb.append(c);
            } else {
                temp.append(c);
            }
        }
        return sb.toString();
    }
}
