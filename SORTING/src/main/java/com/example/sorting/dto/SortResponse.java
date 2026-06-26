package com.example.sorting.dto;

import lombok.Data;

@Data
public class SortResponse {
    private String algorithm;
    private int[] originalNumbers;
    private int[] sortedNumbers;
    private long executionTimeInNanos;
}
