package com.coding.one;

import java.util.ArrayList;
import java.util.List;

public class M241 {

    /**
     * 把运算符想象成树的根节点，不同构造树的顺序，得出不同的结果
     */
    public List<Integer> diffWaysToCompute(String expression) {
        return diffWaysToCompute(expression, 0, expression.length() - 1);
    }

    public List<Integer> diffWaysToCompute(String expression, int s, int e) {
        List<Integer> ans = new ArrayList<>();

        boolean found = false;
        for (int i = s; i <= e; i++) {
            char c = expression.charAt(i);
            if (c != '*' && c != '-' && c != '+') {
                continue;
            }
            found = true;
            List<Integer> leftNodes = diffWaysToCompute(expression, s, i - 1);
            List<Integer> rightNodes = diffWaysToCompute(expression, i + 1, e);

            for (Integer left : leftNodes) {
                for (Integer right : rightNodes) {
                    if (c == '*') {
                        ans.add(left * right);
                    }
                    if (c == '-') {
                        ans.add(left - right);
                    }
                    if (c == '+') {
                        ans.add(left * right);
                    }
                }
            }
        }

        if (!found) {
            ans.add(Integer.parseInt(expression.substring(s, e + 1)));
        }
        return ans;
    }
}
