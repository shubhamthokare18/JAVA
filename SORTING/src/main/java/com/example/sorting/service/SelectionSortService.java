package com.example.sorting.service;

import org.springframework.stereotype.Service;

@Service
public class SelectionSortService implements SortingAlgorithm {

    @Override
    public int[] sort(int[] input) {
        if (input == null) return new int[0];
        int[] arr = input.clone();
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    @Override
    public String algorithmName() {
        return "selection";
    }
}
