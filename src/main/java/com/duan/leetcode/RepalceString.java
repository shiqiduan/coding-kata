package com.duan.leetcode;

public class RepalceString {

    public static String replaceString(String str, String[] array) {
        if (str == null || str.length() == 1 || !str.contains("%s")) {
            return str;
        }
        if (array == null || array.length == 0) {
            return str;
        }

        StringBuilder ret = new StringBuilder();
        int start = 0;
        int replaceTimes = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (start == 1 && c == 's') {
                if (replaceTimes < array.length) {
                    ret.deleteCharAt(ret.length() - 1);
                    ret.append(array[replaceTimes]);
                    replaceTimes++;
                    start = 0;
                    continue;
                } else {
                    ret.append(str.substring(i));
                    break;
                }
            }
            start = (c == '%') ? 1 : 0;
            ret.append(c);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(RepalceString.replaceString("", new String[]{}));
        System.out.println(RepalceString.replaceString("ab %s kan %%sss %ab", new String[]{"1", "2", "3", "4"}));
        System.out.println(RepalceString.replaceString("ab %s kan %%sss %ab", new String[]{"1", "2", "3"}));
        System.out.println(RepalceString.replaceString("ab %s kan %%sss %ab", new String[]{"1", "2"}));
        System.out.println(RepalceString.replaceString("ab %s kan %%sss %ab", new String[]{"1"}));
        System.out.println(RepalceString.replaceString("ab %s kan %%sss %ab", new String[]{}));
        System.out.println(RepalceString.replaceString("", new String[]{}));
        System.out.println(RepalceString.replaceString("aaa  %sss%%%s %as%s", new String[]{"1", "2", "3", "4"}));
    }

}
