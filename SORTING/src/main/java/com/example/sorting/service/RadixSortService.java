package com.example.sorting.service;

import org.springframework.stereotype.Service;

@Service
public class RadixSortService implements SortingAlgorithm {

    @Override
    public int[] sort(int[] input) {
        if (input == null) return new int[0];
        for (int num : input) {
            if (num < 0) throw new IllegalArgumentException("Radix sort does not support negative numbers");
        }
        int[] arr = input.clone();
        radixSort(arr);
        return arr;
    }

    private void radixSort(int[] arr) {
        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    private void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    @Override
    public String algorithmName() {
        return "radix";
    }
}
