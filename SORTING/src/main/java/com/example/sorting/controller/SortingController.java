package com.example.sorting.controller;

import com.example.sorting.dto.SortRequest;
import com.example.sorting.dto.SortResponse;
import com.example.sorting.service.SortingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/sorting")
public class SortingController {

    private final SortingService sortingService;

    public SortingController(SortingService sortingService) {
        this.sortingService = sortingService;
    }

    @PostMapping("/sort")
    public ResponseEntity<SortResponse> sort(@Valid @RequestBody SortRequest request) {
        SortResponse response = sortingService.sort(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/algorithms")
    public ResponseEntity<List<String>> getAlgorithms() {
        List<String> algorithms = List.of("bubble", "selection", "insertion", "merge", "quick", "heap", "counting", "radix", "shell");
        return ResponseEntity.ok(algorithms);
    }
}
