package com.eidiko.temporal.activity;

import com.eidiko.temporal.dto.TravelRequestDto;
import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface TravelActivity {

    public void bookFlight(TravelRequestDto travelRequestDto);

    public void cancelFlight(TravelRequestDto travelRequestDto);

    public void bookHotel(TravelRequestDto travelRequestDto);

    public void cancelHotel(TravelRequestDto travelRequestDto);

    public void bookCab(TravelRequestDto travelRequestDto);

    public void cancelCab(TravelRequestDto travelRequestDto);

    public void cancelBooking(TravelRequestDto travelRequestDto);

    public void confirmBooking(TravelRequestDto travelRequestDto);

}
