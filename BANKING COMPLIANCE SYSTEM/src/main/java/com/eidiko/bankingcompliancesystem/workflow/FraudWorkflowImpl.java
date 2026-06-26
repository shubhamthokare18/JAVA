package com.eidiko.bankingcompliancesystem.workflow;

import org.springframework.stereotype.Component;

@Component
public class FraudWorkflowImpl implements FraudWorkflow {

    @Override
    public void processCase(Long caseId) {
        System.out.println("Processing fraud case: " + caseId);
    }
}
