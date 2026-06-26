package com.eidiko.employee.feign;

import com.eidiko.employee.dto.ManagerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "manager", url = "http://localhost:8081")
public interface EmployeeFeignClient {

    @GetMapping("/manager")
    ManagerResponse getManager(
            @RequestParam Long employeeId
    );

}