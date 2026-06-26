package com.example.sorting.service;

import org.springframework.stereotype.Service;

@Service
public class InsertionSortService implements SortingAlgorithm {

    @Override
    public int[] sort(int[] input) {
        if (input == null) return new int[0];
        int[] arr = input.clone();
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    @Override
    public String algorithmName() {
        return "insertion";
    }
}
