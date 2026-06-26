package com.eidiko.manager.service;

import com.eidiko.manager.dto.ManagerResponse;
import com.eidiko.manager.entity.Manager;
import com.eidiko.manager.repo.ManagerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepo managerRepo;

    @Override
    public ManagerResponse getManager(Long employeeId) {

        Manager manager = managerRepo
                .findByEmployeeId(employeeId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "EMPLOYEE ID NOT FOUND: " + employeeId
                        )
                );

        if (manager.getManagerName() == null ||
                manager.getManagerName().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "MANAGER NOT FOUND FOR EMPLOYEE ID: "
                            + employeeId
            );

        }

        return new ManagerResponse(
                manager.getManagerName()
        );

    }

}