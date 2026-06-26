package com.eidiko.manager.repo;

import com.eidiko.manager.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepo extends JpaRepository<Manager, Long> {

    Optional<Manager> findByEmployeeId(Long employeeId);

}