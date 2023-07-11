package com.coding.two;

public class E202 {
    public boolean isHappy(int n) {
        int slow = n, fast = getNext(n);
        while (fast != 1) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
            if (slow == fast) {
                return false;
            }
        }
        return true;
    }

    private int getNext(int n) {
        int total = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            total += d * d;
        }
        return total;
    }

    public static void main(String[] args) {
        E202 e = new E202();

        System.out.println(e.isHappy(2));
    }
}
