package com.ppg.services.reservation.service;

import com.ppg.services.reservation.entity.Movie;
import com.ppg.services.reservation.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final MovieRepository movieRepository;


    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie createMovie(String title) {
        return movieRepository.save(Movie.builder()
                .title(title)
                .build());
    }

    public Iterable<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

}
