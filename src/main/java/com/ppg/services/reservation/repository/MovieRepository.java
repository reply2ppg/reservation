package com.ppg.services.reservation.repository;

import com.ppg.services.reservation.entity.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Movie m WHERE m.title = :title")
    boolean existsByTitle(@Param("title") String title);

    Movie findByTitle(@Param("title") String title);
}
