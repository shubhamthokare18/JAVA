package com.stanbic.ids.repository;

import com.stanbic.ids.entity.RequestLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestLogRepository extends JpaRepository<RequestLog, Long> {
}
