package com.eidiko.temporal.workflow;

import com.eidiko.temporal.activity.TravelActivity;
import com.eidiko.temporal.dto.TravelRequestDto;
import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Saga;
import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.Workflow;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

@Slf4j
public class TravelWorkflowImpl implements TravelWorkflow {

    private boolean isUserConfirmed = false;

    @SignalMethod
    public void sendConfirmationSignal() {

        log.info("RECEIVED USER CONFIRMATION SIGNAL:");
        isUserConfirmed = true;

    }

    @Override
    public void bookTrip(TravelRequestDto travelRequestDto) {

        Workflow.getLogger(TravelWorkflowImpl.class)
                .info("STARTING TRAVEL BOOKING FOR USER: {}", travelRequestDto.getUserId());

        TravelActivity travelActivity =
                Workflow.newActivityStub(
                        TravelActivity.class,
                        ActivityOptions.newBuilder()
                                .setRetryOptions(RetryOptions.newBuilder()
                                        .setMaximumAttempts(3)
                                        .build())
                                .setStartToCloseTimeout(Duration.ofSeconds(10))
                                .build()
                );

        Saga.Options sagaOptions = new Saga.Options.Builder()
                .setParallelCompensation(false)
                .build();

        Saga saga = new Saga(sagaOptions);

        try {

            travelActivity.bookFlight(travelRequestDto);
            saga.addCompensation(()->travelActivity.cancelFlight(travelRequestDto));

            travelActivity.bookHotel(travelRequestDto);
            saga.addCompensation(()->travelActivity.cancelHotel(travelRequestDto));


            travelActivity.bookCab(travelRequestDto);
            saga.addCompensation(()->travelActivity.cancelCab(travelRequestDto));


            log.info("WAITING FOR USER CONFIRMATION FOR 2 MINUTE");

            boolean isConfirmed = Workflow.await(Duration.ofMinutes(2), () -> isUserConfirmed);

            if (!isConfirmed) {

                log.info("USER DID NOT CONFIRMED WITHIN 2 MINUTE, CANCELLING THE BOOKING FOR USER: {}", travelRequestDto.getUserId());
                travelActivity.cancelBooking(travelRequestDto);

            } else {

                log.info("USER CONFIRMED THE BOOKING: {}", travelRequestDto.getUserId());
                travelActivity.confirmBooking(travelRequestDto);

            }

        } catch (Exception exception) {

            log.error("ERROR DURING TRAVEL BOOKING FOR USER: {}. INITIATING COMPENSATION.",
                    travelRequestDto.getUserId());
            saga.compensate();

        }

        Workflow.getLogger(TravelWorkflowImpl.class)
                .info("TRAVEL BOOKING COMPLETED FOR USER: {}", travelRequestDto.getUserId());

    }

}