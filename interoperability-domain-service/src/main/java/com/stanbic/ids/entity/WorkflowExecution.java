package com.stanbic.ids.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "workflow_execution", schema = "ids_schema")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkflowExecution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String workflowId;
    private String workflowName;
    private String executionStatus;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;

}
