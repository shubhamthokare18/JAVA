package com.eidiko.temporal.workflow;

import com.eidiko.temporal.dto.TravelRequestDto;
import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface TravelWorkflow {

    @WorkflowMethod
    void bookTrip(TravelRequestDto travelRequestDto);

    @SignalMethod
    public void sendConfirmationSignal();
}
