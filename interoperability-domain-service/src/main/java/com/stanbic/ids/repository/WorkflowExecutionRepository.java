package com.stanbic.ids.repository;

import com.stanbic.ids.entity.WorkflowExecution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkflowExecutionRepository extends JpaRepository<WorkflowExecution, Long> {
}
