package com.coding;

public class E434 {
    public int countSegments(String s) {
        int ret = 0;
        for (String w : s.split("\\s+")) {
            if (!"".equals(w)) {
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        E434 s = new E434();

//        System.out.println(Arrays.toString("Hello,    my name is John".split("\\s+")));
//        System.out.println(Arrays.toString("".split("\\s+")));
        System.out.println(s.countSegments("  foo   bar  "));
    }
}
