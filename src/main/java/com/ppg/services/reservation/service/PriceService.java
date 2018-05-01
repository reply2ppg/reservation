package com.ppg.services.reservation.service;

import com.ppg.services.reservation.entity.Movie;
import com.ppg.services.reservation.entity.Price;
import com.ppg.services.reservation.entity.Theater;
import com.ppg.services.reservation.repository.MovieRepository;
import com.ppg.services.reservation.repository.PriceRepository;
import com.ppg.services.reservation.repository.TheaterRepository;
import org.springframework.stereotype.Service;

@Service
public class PriceService {
    private final MovieRepository movieRepository;
    private final TheaterRepository theaterRepository;
    private final PriceRepository priceRepository;

    public PriceService(MovieRepository movieRepository, TheaterRepository theaterRepository, PriceRepository priceRepository) {
        this.movieRepository = movieRepository;
        this.theaterRepository = theaterRepository;
        this.priceRepository = priceRepository;
    }

    public Price createPrice(Movie movie, Theater theater, Double moviePrice){
        if(null == movie || null == theater){
            return null;
        }
        Movie actualMovie = movieRepository.findByTitle(movie.getTitle());
        if(null == actualMovie){
            throw new RuntimeException("Movie does not exist");
        }
        Theater actualTheater = theaterRepository.findTheaterByNameAndCity(theater.getName(), theater.getCity());
        if(null == actualTheater){
            throw new RuntimeException("Theater does not exist");
        }
        return priceRepository.save(Price.builder()
        .movie(actualMovie)
        .theater(actualTheater)
        .moviePrice(moviePrice)
        .build());
    }
}
