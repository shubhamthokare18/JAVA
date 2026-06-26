package com.eidiko.manager.controller;

import com.eidiko.manager.dto.ManagerResponse;
import com.eidiko.manager.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @GetMapping("/manager")
    public ManagerResponse getManager(
            @RequestParam Long employeeId
    ) {

        return managerService.getManager(employeeId);

    }

}