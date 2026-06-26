package com.eidiko.employee.service;

import com.eidiko.employee.dto.ManagerResponse;
import com.eidiko.employee.entity.Employee;
import com.eidiko.employee.feign.EmployeeFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeFeignClient employeeFeignClient;

    @Override
    public void processEmployee(Employee employee) {

        log.info(
                "PROCESSING EMPLOYEE ID: {}",
                employee.getEmployeeId()
        );

        ManagerResponse response =
                employeeFeignClient.getManager(
                        employee.getEmployeeId()
                );

        employee.setManagerName(
                response.getManagerName()
        );

        employee.setStatus("SUCCESS");

    }

}