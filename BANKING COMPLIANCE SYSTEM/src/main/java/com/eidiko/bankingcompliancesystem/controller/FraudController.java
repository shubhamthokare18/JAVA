package com.eidiko.bankingcompliancesystem.controller;

import com.eidiko.bankingcompliancesystem.entity.FraudCase;
import com.eidiko.bankingcompliancesystem.service.FraudService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fraud")
@RequiredArgsConstructor
public class FraudController {

    private final FraudService service;

    @PostMapping("/create")
    public ResponseEntity<FraudCase> create(@Valid @RequestBody FraudCase fraudCase) {
        FraudCase created = service.create(fraudCase);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FraudCase> getById(@PathVariable Long id) {
        Optional<FraudCase> fraudCase = service.getById(id);
        return fraudCase.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<FraudCase>> getAll() {
        List<FraudCase> fraudCases = service.getAll();
        return ResponseEntity.ok(fraudCases);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FraudCase> update(@PathVariable Long id, @Valid @RequestBody FraudCase fraudCase) {
        FraudCase updated = service.update(id, fraudCase);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
