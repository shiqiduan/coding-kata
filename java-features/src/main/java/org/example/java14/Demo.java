package org.example.java14;

import static java.util.Calendar.*;

public class Demo {
    public static void main(String[] args) {
        testSwitch();
        testRecord();
        testNullPointerExceptions();
        testInstanceOf();
    }

    public static void testSwitch() {
        int day = 10;
        int numLetters = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            default -> {
                yield day + 1;
            }
        };
        System.out.println(numLetters);
    }

    /**
     * 不可变对象
     */
    public static void testRecord() {
        Point p1 = new Point(10, 100);
        Point p2 = new Point(10, 100);
        Point p3 = new Point();
        Point p4 = new Point(50);

        System.out.println(p1);
        System.out.println(p1.x());
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3);
    }

    public static void testNullPointerExceptions() {
        String a = "a";
        try {
            a = null;
            a.length();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void testInstanceOf() {
        Object obj = "aaaaa";
        if (obj instanceof String s) {
            System.out.println(s.contains("aaa"));
        }
    }
}

record Point(int x, int y) {
    private static final int ZERO = 0;
    private static long instanceCounter = 0;

    public Point() {
        this(ZERO, ZERO);
    }

    public Point(int value) {
        this(value, value);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;

        synchronized (Point.class) {
            instanceCounter++;
            System.out.println("数量:" + instanceCounter);
        }
    }
}