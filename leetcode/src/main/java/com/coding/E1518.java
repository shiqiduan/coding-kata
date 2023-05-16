package com.coding;

public class E1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = numBottles;
        int ret = numBottles;

        while (sum >= numExchange) {
            ret += (sum / numExchange);
            sum = (sum / numExchange) + (sum % numExchange);
        }

        return ret;
    }

    public static void main(String[] args) {
        E1518 e = new E1518();
        System.out.println(e.numWaterBottles(9, 3));
    }
}
