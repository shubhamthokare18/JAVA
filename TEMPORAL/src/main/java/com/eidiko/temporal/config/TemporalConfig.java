package com.eidiko.temporal.config;

import com.eidiko.temporal.activity.TravelActivityImpl;
import com.eidiko.temporal.workflow.TravelWorkflowImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemporalConfig {

    @Bean
    public WorkflowServiceStubs workflowServiceStubs() {

        return WorkflowServiceStubs.newInstance();
    }

    @Bean
    public WorkflowClient workflowClient(
            WorkflowServiceStubs workflowServiceStubs) {

        return WorkflowClient.newInstance(workflowServiceStubs);
    }

    @Bean
    public WorkerFactory workerFactory(
            WorkflowClient workflowClient) {

        WorkerFactory workerFactory =
                WorkerFactory.newInstance(workflowClient);

        Worker worker =
                workerFactory.newWorker("TRAVEL_TASK_QUEUE");

        worker.registerWorkflowImplementationTypes(
                TravelWorkflowImpl.class);

        worker.registerActivitiesImplementations(
                new TravelActivityImpl());

        workerFactory.start();

        System.out.println("TEMPORAL WORKERS STARTED");

        return workerFactory;
    }
}