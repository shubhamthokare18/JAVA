package com.example.sorting.service;

import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class CountingSortService implements SortingAlgorithm {

    @Override
    public int[] sort(int[] input) {
        if (input == null) return new int[0];
        for (int num : input) {
            if (num < 0) throw new IllegalArgumentException("Counting sort does not support negative numbers");
        }
        int max = Arrays.stream(input).max().orElse(0);
        int[] count = new int[max + 1];
        for (int num : input) count[num]++;
        int[] sorted = new int[input.length];
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                sorted[index++] = i;
            }
        }
        return sorted;
    }

    @Override
    public String algorithmName() {
        return "counting";
    }
}
