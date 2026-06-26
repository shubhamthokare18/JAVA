package com.example.sorting.service;

import org.springframework.stereotype.Service;

@Service
public class ShellSortService implements SortingAlgorithm {

    @Override
    public int[] sort(int[] input) {
        if (input == null) return new int[0];
        int[] arr = input.clone();
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
        return arr;
    }

    @Override
    public String algorithmName() {
        return "shell";
    }
}
