package com.duan.leetcode;

import java.util.*;

public class S10001 {

    private static Set<Character> operatorSet = new HashSet<>();

    static {
        operatorSet.add('+');
        operatorSet.add('-');
        operatorSet.add('*');
        operatorSet.add('/');
    }

    public long calculate(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }
        List<Long> operandList = new ArrayList<>();
        List<Character> operatorList = new ArrayList<>();

        StringBuilder operandSb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char x = expression.charAt(i);
            if (!operatorSet.contains(x)) {
                operandSb.append(x);
                continue;
            }

            Long operand = Long.parseLong(operandSb.toString());
            operandSb = new StringBuilder();

            if (operatorList.isEmpty()) {
                operandList.add(operand);
                operatorList.add(x);
                continue;
            }

            Character lastOperator = operatorList.get(operatorList.size() - 1);
            Long lastOperand = operandList.get(operandList.size() - 1);
            if(lastOperator == '*') {
                operandList.set(operandList.size() - 1, lastOperand * operand);
                operatorList.set(operatorList.size() - 1, x);
            } else if(lastOperator == '/') {
                operandList.set(operandList.size() - 1, lastOperand / operand);
                operatorList.set(operatorList.size() - 1, x);
            } else {
                operandList.add(operand);
                operatorList.add(x);
            }
        }
        Long operand = Long.parseLong(operandSb.toString());

        while (!operatorList.isEmpty()) {
            Long lastOperand = operandList.get(operandList.size() - 1);
            Character lastOperator = operatorList.get(operatorList.size() - 1);
            operatorList.remove(operatorList.size() - 1);
            operandList.remove(operandList.size() - 1);

            if (lastOperator == '+') {
                operand = lastOperand + operand;
            } else if (lastOperator == '-') {
                operand = lastOperand - operand;
            } else if (lastOperator == '*') {
                operand = lastOperand * operand;
            } else if (lastOperator == '/') {
                operand = lastOperand / operand;
            }
        }

        return operand;
    }

    public static void main(String[] args) {
        S10001 s = new S10001();

        System.out.println(s.calculate("1+2*4-5/2") + " = " + 7);
        System.out.println(s.calculate("10+2*4-10/2") + " = " + 13);
        System.out.println(s.calculate("1*2*3/4") + " = " + 1);
    }

}
