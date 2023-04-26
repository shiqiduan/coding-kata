package com.coding;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMostCommonWord {

    @Test
    public void testMostCommonWord() {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};

        E819 finder = new E819();
        String result = finder.mostCommonWord(paragraph, banned);

        assertEquals("ball", result);
    }

    @Test
    public void testMostCommonWord2() {
        String paragraph = "Bob. hIt, baLl";
        String[] banned = {"bob", "hit"};

        E819 finder = new E819();
        String result = finder.mostCommonWord(paragraph, banned);

        assertEquals("ball", result);
    }

}
