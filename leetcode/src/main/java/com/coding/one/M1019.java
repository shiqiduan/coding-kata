package com.coding.one;

import com.coding.ListNode;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class M1019 {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> ansList = new ArrayList<>();
        head = reverseList(head);
        ListNode curr = head;
        Stack<Integer> stack = new Stack<>();
        while (curr != null) {
            if (!stack.isEmpty()) {
                System.out.println(stack.peek() + " " + (curr.val >= stack.peek()));
            }
            while (!stack.isEmpty() && curr.val >= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ansList.add(0);
            } else {
                ansList.add(stack.peek());
            }
            stack.add(curr.val);
            curr = curr.next;
        }

        Collections.reverse(ansList);
        return ansList.stream().mapToInt(value -> value).toArray();
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        M1019 m = new M1019();

        int[] params = new int[]{1, 7, 5, 1, 9};
        int[] expect = new int[]{7, 9, 9, 9, 0};

        Assert.assertArrayEquals(expect, m.nextLargerNodes(makeList(params)));
    }

    private static ListNode makeList(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode head = new ListNode(0), curr = head;
        for (int j : array) {
            curr.next = new ListNode(j);
            curr = curr.next;
        }
        return head.next;
    }
}
