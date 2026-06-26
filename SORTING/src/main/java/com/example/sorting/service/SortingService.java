package com.example.sorting.service;

import com.example.sorting.dto.SortRequest;
import com.example.sorting.dto.SortResponse;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SortingService {

    private final Map<String, SortingAlgorithm> algorithms;

    public SortingService(List<SortingAlgorithm> sortingAlgorithms) {
        this.algorithms = sortingAlgorithms.stream()
                .collect(Collectors.toMap(SortingAlgorithm::algorithmName, Function.identity()));
    }

    public SortResponse sort(SortRequest request) {
        String algorithm = request.getAlgorithm();
        if (!algorithms.containsKey(algorithm)) {
            throw new IllegalArgumentException("Invalid algorithm: " + algorithm);
        }
        int[] original = request.getNumbers();
        long start = System.nanoTime();
        int[] sorted = algorithms.get(algorithm).sort(original);
        long end = System.nanoTime();
        SortResponse response = new SortResponse();
        response.setAlgorithm(algorithm);
        response.setOriginalNumbers(original);
        response.setSortedNumbers(sorted);
        response.setExecutionTimeInNanos(end - start);
        return response;
    }
}
