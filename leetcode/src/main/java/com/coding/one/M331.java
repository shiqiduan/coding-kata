package com.coding.one;

import java.util.ArrayList;
import java.util.List;

public class M331 {
    public boolean isValidSerialization(String preorder) {
        List<String> stack = new ArrayList<>();

        String[] split = preorder.split(",");
        for (int i = 0; i < split.length; i++) {
            String c = split[i];
            if (c.equals("#") && stack.size() >= 2 && stack.get(stack.size() - 1).equals("#")
                    && !stack.get(stack.size() - 2).equals("#")) {
                stack.remove(stack.size() - 1);
                stack.remove(stack.size() - 1);
                i--;
                continue;
            }
            stack.add(c);
        }
        System.out.println(stack);
        return stack.size() == 1 && stack.get(0).equals("#");
    }

    public static void main(String[] args) {
        M331 m = new M331();
        System.out.println(m.isValidSerialization("1"));
        System.out.println(m.isValidSerialization("#"));
        // System.out.println(m.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
