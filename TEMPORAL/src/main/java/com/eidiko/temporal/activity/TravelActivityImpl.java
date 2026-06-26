package com.eidiko.temporal.activity;

import com.eidiko.temporal.dto.TravelRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TravelActivityImpl implements TravelActivity {

    @Override
    public void bookFlight(TravelRequestDto travelRequestDto) {

        log.info("FLIGHT BOOKED FOR USER: {} TO DESTINATION: {} ON DATE: {}",
                travelRequestDto.getUserId(),
                travelRequestDto.getDestination(),
                travelRequestDto.getTravelDate());

    }

    @Override
    public void cancelFlight(TravelRequestDto travelRequestDto) {

        log.info("CANCELLING FLIGHT FOR USER {} BECAUSE OF FAILURE",
                travelRequestDto.getUserId());

    }

    @Override
    public void bookHotel(TravelRequestDto travelRequestDto) {

        log.info("HOTEL BOOKED FOR USER: {} AT DESTINATION: {} ON DATE: {}",
                travelRequestDto.getUserId(),
                travelRequestDto.getDestination(),
                travelRequestDto.getTravelDate());

    }

    @Override
    public void cancelHotel(TravelRequestDto travelRequestDto) {

        log.info("CANCELLING HOTEL FOR USER {} BECAUSE OF FAILURE",
                travelRequestDto.getUserId());

    }

    @Override
    public void bookCab(TravelRequestDto travelRequestDto) {

        log.info("CAB BOOKED FOR USER: {} AT DESTINATION: {} ON DATE: {}",
                travelRequestDto.getUserId(),
                travelRequestDto.getDestination(),
                travelRequestDto.getTravelDate());

        throw new RuntimeException("SIMULATED CAB BOOKED FAILURE!");

    }

    @Override
    public void cancelCab(TravelRequestDto travelRequestDto) {

        log.info("CANCELLING CAB FOR USER {}",
                travelRequestDto.getUserId());

    }

    @Override
    public void cancelBooking(TravelRequestDto travelRequestDto) {

        log.info("CANCELLING BOOKING FOR USER: {} AT DESTINATION: {} ON DATE: {}",
                travelRequestDto.getUserId(),
                travelRequestDto.getDestination(),
                travelRequestDto.getTravelDate());

    }

    @Override
    public void confirmBooking(TravelRequestDto travelRequestDto) {

        log.info("BOOKING CONFIRMED FOR USER: {} AT DESTINATION: {} ON DATE: {}",
                travelRequestDto.getUserId(),
                travelRequestDto.getDestination(),
                travelRequestDto.getTravelDate());

    }

}
