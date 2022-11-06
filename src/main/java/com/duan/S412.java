package com.duan;

import java.util.ArrayList;
import java.util.List;

public class S412 {
    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int x3 = i % 3, x5 = i % 5;

            if(x3 == 0 && x5 == 0) {
                ret.add("FizzBuzz");
            } else if(x3 == 0) {
                ret.add("Fizz");
            } else if(x5 == 0) {
                ret.add("Buzz");
            } else {
                ret.add(i + "");
            }
        }
        return ret;
    }
}
