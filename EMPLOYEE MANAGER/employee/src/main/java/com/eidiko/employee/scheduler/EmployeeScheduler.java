package com.eidiko.employee.scheduler;

import com.eidiko.employee.entity.Employee;
import com.eidiko.employee.repo.EmployeeRepo;
import com.eidiko.employee.service.EmployeeService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmployeeScheduler {

    private final EmployeeService employeeService;
    private final EmployeeRepo employeeRepo;

    @Scheduled(fixedDelay = 10000)
    public void runJob() {

        log.info("SCHEDULER STARTED");

        List<Employee> employeeList =
                employeeRepo.findByStatus("PENDING");

        for (Employee employee : employeeList) {

            try {

                employeeService.processEmployee(employee);

                employeeRepo.save(employee);

                log.info(
                        "SUCCESS FOR EMPLOYEE ID: {}",
                        employee.getEmployeeId()
                );

            } catch (FeignException.BadRequest exception) {

                String errorMessage =
                        exception.contentUTF8();

                employee.setStatus("FAILED");

                employee.setErrorMessage(errorMessage);

                employeeRepo.save(employee);

                log.error(
                        "FAILED FOR EMPLOYEE ID: {} -> {}",
                        employee.getEmployeeId(),
                        errorMessage
                );

            } catch (Exception exception) {

                employee.setStatus("FAILED");

                employee.setErrorMessage(
                        exception.getMessage()
                );

                employeeRepo.save(employee);

                log.error(
                        "UNEXPECTED ERROR FOR EMPLOYEE ID: {}",
                        employee.getEmployeeId()
                );

            }

        }

        log.info("SCHEDULER COMPLETED");

    }

}