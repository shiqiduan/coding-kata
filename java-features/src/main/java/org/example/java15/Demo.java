package org.example.java15;

public class Demo {

    private static void testBlock() {
        String text = """
                Lorem ipsum dolor sit amet, consectetur adipiscing
                elit, sed do eiusmod tempor incididunt ut labore \
                et dolore magna aliqua.\
                """;
        System.out.println(text);
    }

    private static void testSealed() {

    }

    public static void main(String[] args) {
        testBlock();
    }
}

abstract sealed class Shape permits Circle {
    protected String name;
}

final class Circle extends Shape {

}

