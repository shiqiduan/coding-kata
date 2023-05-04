package com.coding;

import java.util.ArrayList;
import java.util.List;

public class E119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> last = new ArrayList<Integer>();
        last.add(1);
        if (rowIndex == 0) {
            return last;
        }

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for (int j = 1; j < last.size(); j++) {
                current.add(last.get(j - 1) + last.get(j));
            }
            current.add(1);
            last = current;
        }
        return last;
    }
}
