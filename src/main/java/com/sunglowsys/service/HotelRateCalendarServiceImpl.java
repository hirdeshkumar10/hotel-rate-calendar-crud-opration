package com.sunglowsys.service;

import com.sunglowsys.domain.HotelRateCalendar;
import com.sunglowsys.repository.HotelRateCalendarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelRateCalendarServiceImpl implements HotelRateCalendarService{

    private final Logger log = LoggerFactory.getLogger(HotelRateCalendar.class);

    private final HotelRateCalendarRepository hotelRateCalendarRepository;

    public HotelRateCalendarServiceImpl(HotelRateCalendarRepository hotelRateCalendarRepository) {
        this.hotelRateCalendarRepository = hotelRateCalendarRepository;
    }


    @Override
    public HotelRateCalendar create(HotelRateCalendar hotelRateCalendar) {
        log.debug("Request to create HotelRateCalendar: {}",hotelRateCalendar);
        return hotelRateCalendarRepository.save(hotelRateCalendar);
    }

    @Override
    public HotelRateCalendar update(HotelRateCalendar hotelRateCalendar) {
        log.debug("Request to update HotelRateCalendar: {}",hotelRateCalendar);
        return hotelRateCalendarRepository.save(hotelRateCalendar);
    }

    @Override
    public List<HotelRateCalendar> findAll() {
        log.debug("Request to findAll HotelRateCalendar:");
        return hotelRateCalendarRepository.findAll();
    }

    @Override
    public Optional<HotelRateCalendar> findById(Long id) {
        log.debug("Request to create HotelRateCalendar: {}",id);
        return hotelRateCalendarRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to create HotelRateCalendar: {}",id);
        hotelRateCalendarRepository.deleteById(id);

    }
}