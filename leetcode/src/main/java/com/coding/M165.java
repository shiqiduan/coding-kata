package com.coding;

public class M165 {
    public int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) return 0;

        String[] va1 = version1.split("\\.");
        String[] va2 = version2.split("\\.");

        int a = 0, b = 0;

        while (a < va1.length || b < va2.length) {
            int av = (a < va1.length) ? Integer.parseInt(va1[a]) : 0;
            int bv = (b < va2.length) ? Integer.parseInt(va2[b]) : 0;
            if (av > bv) {
                return 1;
            } else if (bv > av) {
                return -1;
            }
            a++;
            b++;
        }
        return 0;
    }

    public static void main(String[] args) {
        M165 m = new M165();
        System.out.println(m.compareVersion("1.01", "1.001"));
        System.out.println(m.compareVersion("1.0", "1.0.0.0"));
        System.out.println(m.compareVersion("1.0.0", "1.0.0.001"));
    }
}
