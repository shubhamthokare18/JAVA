package com.eidiko.bankingcompliancesystem.workflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface FraudWorkflow {

    @WorkflowMethod
    void processCase(Long caseId);
}