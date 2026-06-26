package com.eidiko.bankingcompliancesystem.service;

import com.eidiko.bankingcompliancesystem.entity.FraudCase;
import com.eidiko.bankingcompliancesystem.repository.FraudRepository;
import com.eidiko.bankingcompliancesystem.workflow.FraudWorkflow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FraudService {

    private final FraudRepository repo;
    private final FraudWorkflow fraudWorkflow;

    public FraudCase create(FraudCase fraudCase) {
        log.info("Creating fraud case with description: {}", fraudCase.getDescription());
        FraudCase saved = repo.save(fraudCase);
        fraudWorkflow.processCase(saved.getId());
        return saved;
    }

    public Optional<FraudCase> getById(Long id) {
        log.info("Fetching fraud case with id: {}", id);
        return repo.findById(id);
    }

    public List<FraudCase> getAll() {
        log.info("Fetching all fraud cases");
        return repo.findAll();
    }

    public FraudCase update(Long id, FraudCase fraudCase) {
        log.info("Updating fraud case with id: {}", id);
        if (repo.existsById(id)) {
            fraudCase.setId(id);
            return repo.save(fraudCase);
        }
        return null;
    }

    public void delete(Long id) {
        log.info("Deleting fraud case with id: {}", id);
        repo.deleteById(id);
    }
}
