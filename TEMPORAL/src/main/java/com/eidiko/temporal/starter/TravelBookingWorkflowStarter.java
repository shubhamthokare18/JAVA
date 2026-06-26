package com.eidiko.temporal.starter;

import com.eidiko.temporal.dto.TravelRequestDto;
import com.eidiko.temporal.workflow.TravelWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TravelBookingWorkflowStarter {

    @Autowired
    private WorkflowClient workflowClient;

    public void startWorkflow(TravelRequestDto travelRequestDto) {

        TravelWorkflow travelWorkflow = workflowClient.newWorkflowStub(
                TravelWorkflow.class,
                WorkflowOptions.newBuilder()
                        .setTaskQueue("TRAVEL_TASK_QUEUE")
                        .setWorkflowId("TRAVEL_" + travelRequestDto.getUserId())
                        .build()
        );

        WorkflowClient.start(
                travelWorkflow::bookTrip,
                travelRequestDto
        );
    }

    public void sendConfirmationSignal(String userId) {

        String workflowId = "TRAVEL_" + userId;
        TravelWorkflow travelWorkflow = workflowClient.newWorkflowStub(TravelWorkflow.class, workflowId);
        travelWorkflow.sendConfirmationSignal();

    }

}