package org.example.java9;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demo {
    static {
        List<String> list = List.of("one", "two", "three");
        Set<String> set = Set.of("one", "two", "three");
        Map<String, String> map = Map.of("foo", "one", "bar", "two");
        Map<String, String> map1 = Map.of("foo", "one", "bar", "two");

        System.out.println(list);
        System.out.println(set);
        System.out.println(map);
    }

    public static void main(String[] args) {

    }
}
