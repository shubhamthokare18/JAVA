package com.eidiko.temporal.controller;

import com.eidiko.temporal.dto.TravelRequestDto;
import com.eidiko.temporal.starter.TravelBookingWorkflowStarter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/travel")
public class TravelWorkflowController {

    private final TravelBookingWorkflowStarter travelBookingWorkflowStarter;

    public TravelWorkflowController(TravelBookingWorkflowStarter travelBookingWorkflowStarter) {

        this.travelBookingWorkflowStarter = travelBookingWorkflowStarter;

    }

    @PostMapping("/book")
    public ResponseEntity<String> bookTravel(@RequestBody TravelRequestDto travelRequestDto) {

        travelBookingWorkflowStarter.startWorkflow(travelRequestDto);

        return ResponseEntity.ok("TRAVEL BOOKING WORKFLOW STARTED FOR USER: " + travelRequestDto.getUserId());

    }

    @PostMapping("/confirm/{userId}")
    public ResponseEntity<String> confirmBooking(@RequestParam String userId) {

        travelBookingWorkflowStarter.sendConfirmationSignal(userId);

        return ResponseEntity.ok("BOOKING CONFIRMED BY USER!");
    }

}
