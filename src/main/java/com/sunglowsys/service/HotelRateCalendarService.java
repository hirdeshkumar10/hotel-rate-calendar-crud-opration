package com.sunglowsys.service;

import com.sunglowsys.domain.HotelRateCalendar;

import java.util.List;
import java.util.Optional;

public interface HotelRateCalendarService {

    HotelRateCalendar create(HotelRateCalendar hotelRateCalendar);

    HotelRateCalendar update(HotelRateCalendar hotelRateCalendar);

    List<HotelRateCalendar> findAll();

    Optional<HotelRateCalendar> findById(Long id);

    void delete(Long id);
}
