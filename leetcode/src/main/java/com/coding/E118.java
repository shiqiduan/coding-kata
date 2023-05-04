package com.coding;

import java.util.ArrayList;
import java.util.List;

public class E118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> l0 = new ArrayList<Integer>();
        l0.add(1);
        ret.add(l0);
        for (int i = 1; i < numRows; i++) {
            List<Integer> last = ret.get(i - 1);
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for (int j = 1; j < last.size(); j++) {
                current.add(last.get(j - 1) + last.get(j));
            }
            current.add(1);
            ret.add(current);
        }
        return ret;
    }

    public static void main(String[] args) {
        E118 e = new E118();
        List<List<Integer>> ret = e.generate(1);
        ret = e.generate(5);
    }
}
