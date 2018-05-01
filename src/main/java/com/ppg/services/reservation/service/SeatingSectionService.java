/*
package com.ppg.services.reservation.service;

import com.ppg.services.reservation.entity.SeatingSection;
import com.ppg.services.reservation.entity.Theater;
import com.ppg.services.reservation.repository.SeatingSectionRepository;
import com.ppg.services.reservation.repository.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatingSectionService {
    private final SeatingSectionRepository seatingSectionRepository;
    private final TheaterRepository theaterRepository;

    public SeatingSectionService(SeatingSectionRepository seatingSectionRepository, TheaterRepository theaterRepository) {
        this.seatingSectionRepository = seatingSectionRepository;
        this.theaterRepository = theaterRepository;
    }

    public SeatingSection createSeatingSection(String seatingSectionName, Theater theater) {
        Theater availableTheater = theaterRepository.findTheaterByNameAndCity(theater.getName(), theater.getCity());
        if(null == availableTheater){
            throw new RuntimeException("Theater does not exist");
            }
        return seatingSectionRepository.save(SeatingSection.builder()
                .name(seatingSectionName)
                .theater(availableTheater)
                .build());
    }

    public List<SeatingSection> getSeatingSectionsByName(String name){
        return seatingSectionRepository.findSeatingSectionByName(name);
    }
}
*/
