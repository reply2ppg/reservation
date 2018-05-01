package com.ppg.services.reservation.service;

import com.ppg.services.reservation.entity.Theater;
import com.ppg.services.reservation.repository.TheaterRepository;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {
    private final TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public Theater createTheater(String name, String city) {
        return theaterRepository.save(Theater.builder()
                .city(city)
                .name(name)
                .build());
    }

    public Iterable<Theater> getAllTheater(){
        return theaterRepository.findAll();
    }

}

