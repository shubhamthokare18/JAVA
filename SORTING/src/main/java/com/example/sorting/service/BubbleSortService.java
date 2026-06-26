package com.example.sorting.service;

import org.springframework.stereotype.Service;

@Service
public class BubbleSortService implements SortingAlgorithm {

    @Override
    public int[] sort(int[] input) {
        if (input == null) return new int[0];
        int[] arr = input.clone();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    @Override
    public String algorithmName() {
        return "bubble";
    }
}
