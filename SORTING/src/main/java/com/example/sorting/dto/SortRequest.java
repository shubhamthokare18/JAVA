package com.example.sorting.dto;

import lombok.Data;

@Data
public class SortRequest {
    private String algorithm;
    private int[] numbers;
}
