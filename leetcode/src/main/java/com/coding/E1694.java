package com.coding;

public class E1694 {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (!Character.isDigit(c)) {
                continue;
            }
            sb.append(c);
            index++;
            if (index == 5) {
                sb.insert(sb.length() - 2, '-');
                index = 2;
            }
        }
        if (index == 4) {
            sb.insert(sb.length() - 2, '-');
        }
        return sb.toString();
    }
}
