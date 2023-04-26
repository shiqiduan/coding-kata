package com.coding;

import org.junit.Assert;
import org.junit.Test;

public class TestE821 {
    @Test
    public void testShortestToChar() {
        E821 e821 = new E821();

        Assert.assertArrayEquals(new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}, e821.shortestToChar("loveleetcode", 'e'));
    }

    public void testShortestToChar2() {
        E821 e821 = new E821();

        Assert.assertArrayEquals(new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}, e821.shortestToChar2("loveleetcode", 'e'));
    }

}
