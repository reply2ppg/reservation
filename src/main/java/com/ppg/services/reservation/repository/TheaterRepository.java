package com.ppg.services.reservation.repository;

import com.ppg.services.reservation.entity.Theater;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TheaterRepository extends CrudRepository<Theater, Integer> {

    Theater findTheaterByNameAndCity(@Param("name") String name, @Param("city") String city);
    List<Theater> findTheaterByCity(@Param("city") String city);
    List<Theater> findTheaterByName(@Param("name") String name);

    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM Theater t WHERE t.name = :name AND t.city = :city")
    boolean existsByNameAndCity(@Param("name") String name, @Param("city") String city);

}
