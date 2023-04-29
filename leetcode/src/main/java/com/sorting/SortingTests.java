package com.sorting;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class SortingTests {
    public static final Logger logger = LoggerFactory.getLogger(SortingTests.class);

    public static void main(String[] args) {
//        Sorting sorter = new InsertionSort();
//        Sorting sorter = new BubbleSort();
//        Sorting sorter = new SelectionSort();
        Sorting sorter = new QuickSort();

        assertArray(new int[]{3, 3, 3, 3, 1}, sorter);
        assertArray(new int[]{1, 2, 3}, sorter);
        // create assertArray use random params
        assertArray(new int[]{1}, sorter);
        assertArray(new int[]{1, 2, 3, 4, 5}, sorter);
        assertArray(new int[]{5, 4, 3, 2, 1}, sorter);
        assertArray(new int[]{1, 2, 3, 4, 5, 6}, sorter);
        assertArray(new int[]{6, 5, 4, 3, 2, 1}, sorter);
        assertArray(new int[]{1, 2, 3, 4, 5, 6, 7}, sorter);
        assertArray(new int[]{1, 2, 3, 3, 3, 7}, sorter);
    }

    private static void assertArray(int[] nums, Sorting sorter) {
        int[] expected = Arrays.copyOf(nums, nums.length);
        Arrays.sort(expected);
        int[] acutal = sorter.sort(nums);
        logger.info("expected : {}, actual : {}", expected, acutal);
        Assert.assertArrayEquals(expected, sorter.sort(nums));
    }
}
