package com.sunglowsys.rest;

import com.sunglowsys.domain.HotelRateCalendar;
import com.sunglowsys.service.HotelRateCalendarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HotelRateCalendarResource {

    private final Logger log = LoggerFactory.getLogger(HotelRateCalendarResource.class);

    private final HotelRateCalendarService hotelRateCalendarService;

    public HotelRateCalendarResource(HotelRateCalendarService hotelRateCalendarService) {
        this.hotelRateCalendarService = hotelRateCalendarService;
    }

    @PostMapping("/hotel-rate-calendars")
    public ResponseEntity<HotelRateCalendar> createHotelRateCalendar(@RequestBody HotelRateCalendar hotelRateCalendar) throws URISyntaxException {
        log.debug("Rest request to save HotelRateCalendar: {}",hotelRateCalendar);
        if (hotelRateCalendar.getId() != null){
            throw new RuntimeException("Id should be null in create api calls");
        }
        HotelRateCalendar result = hotelRateCalendarService.create(hotelRateCalendar);
        return ResponseEntity
                .created(new URI("/api/hotel-rate-calendar/"+result.getId()))
                .body(result);

    }

    @PutMapping("/hotel-rate-calendars")
    public ResponseEntity<HotelRateCalendar> updateHotelRateCalendar(@RequestBody HotelRateCalendar hotelRateCalendar ){
        log.debug("Rest request to update HotelRateCalendar: {}",hotelRateCalendar);
        if (hotelRateCalendar.getId() == null){
            throw new RuntimeException("Id should not be null in update api calls");
        }
        HotelRateCalendar result = hotelRateCalendarService.update(hotelRateCalendar);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/hotel-rate-calendars")
    public ResponseEntity<List<HotelRateCalendar>> findAllHotelRateCalendar(){
        log.debug("Rest request to find to list HotelRateCalendar:");
        List<HotelRateCalendar> result = hotelRateCalendarService.findAll();
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/hotel-rate-calendars/{id}")
    public ResponseEntity<HotelRateCalendar> findByIdHotelRateCalendar(@PathVariable Long id){
        log.debug("Rest request to find to all HotelRateCalendar:");
        Optional<HotelRateCalendar> result = hotelRateCalendarService.findById(id);
        return ResponseEntity
                .ok()
                .body(result.get());
    }

    @DeleteMapping("/hotel-rate-calendar/{id}")
    public ResponseEntity<Void> deleteHotelRateCalendar(@PathVariable ("id")Long id){
        log.debug("Rest request to  delete  HotelRateCalendar:");
        hotelRateCalendarService.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }


}
