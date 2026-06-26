package com.example.sorting.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuickSortServiceTest {

    private final QuickSortService service = new QuickSortService();

    @Test
    void testSortEmptyArray() {
        int[] input = {};
        int[] expected = {};
        assertArrayEquals(expected, service.sort(input));
    }

    @Test
    void testSortSingleElement() {
        int[] input = {5};
        int[] expected = {5};
        assertArrayEquals(expected, service.sort(input));
    }

    @Test
    void testSortAlreadySorted() {
        int[] input = {1, 2, 3};
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, service.sort(input));
    }

    @Test
    void testSortReverseSorted() {
        int[] input = {3, 2, 1};
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, service.sort(input));
    }

    @Test
    void testSortWithDuplicates() {
        int[] input = {3, 1, 2, 1};
        int[] expected = {1, 1, 2, 3};
        assertArrayEquals(expected, service.sort(input));
    }

    @Test
    void testSortWithNegatives() {
        int[] input = {-1, 3, -2};
        int[] expected = {-2, -1, 3};
        assertArrayEquals(expected, service.sort(input));
    }

    @Test
    void testSortNull() {
        int[] result = service.sort(null);
        assertArrayEquals(new int[0], result);
    }
}
