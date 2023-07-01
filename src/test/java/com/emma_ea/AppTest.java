package com.emma_ea;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    App app;

    @Before
    public void setup() {
        app = new App();
    }

    @Test
    public void calculatorAddsValidInput() {
        int result = app.calculator("1+2");
        assertEquals(3, result);
    }

    @Test
    public void calculatorAddsValidSecondTestInput() {
        int result = app.calculator("1*2+10");
        assertEquals(12, result);
    }

    @Test
    public void calculatorReturnsZeroOnEmptyInput() {
        int result = app.calculator("");
        assertEquals(0, result);
    }

    @Test
    public void calculateFrequencyFromValidList() {
        List<String> words = new ArrayList<>();
        words.add("abc");
        words.add("bbc");
        words.add("abc");
        List<String> res = app.calculateWordFrequency(words);
        assertEquals("abc | 2", res.get(0));
        assertEquals("bbc | 1", res.get(1));
    }

    @Test
    public void findIndexOfFirstDuplicateInString() {
        int res = app.findDuplicate("hello");
        // second l at idx 3 is duplicate
        assertEquals(3, res);
    }

    @Test
    public void findKLargestFourNumbersInList() {
        int[] arr = {-1, 11, 22, 5, 66, 43, 7};
        int k = 4;
        List<Integer> res = app.findKLargest(arr, k);
        assertEquals(Arrays.asList(11, 22, 43, 66), res);
    }

    @Test
    public void findKLargestTwoNumbersInList() {
        int[] arr = {-1, 11, 22, 5, 66, 43, 7};
        int k = 2;
        List<Integer> res = app.findKLargest(arr, k);
        assertEquals(Arrays.asList(43, 66), res);
    }
}
