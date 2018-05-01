package com.ppg.services.reservation.repository;

import com.ppg.services.reservation.entity.Movie;
import com.ppg.services.reservation.entity.Price;
import com.ppg.services.reservation.entity.Theater;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PriceRepository extends CrudRepository<Price, Integer> {
    Price findByMovieTitleAndTheaterCityAndTheaterName(@Param("title") String title, @Param("city") String city, @Param("name") String name);

    List<Price> findByTheaterName(@Param("name") String name);

    List<Price> findByTheaterCity(@Param("city") String city);

    List<Price> findByMovieTitle(@Param("title") String title);
}
