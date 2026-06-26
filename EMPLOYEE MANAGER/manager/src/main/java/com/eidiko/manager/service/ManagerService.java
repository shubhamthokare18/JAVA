package com.eidiko.manager.service;

import com.eidiko.manager.dto.ManagerResponse;

public interface ManagerService {

    ManagerResponse getManager(Long employeeId);

}