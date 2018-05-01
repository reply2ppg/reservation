package com.ppg.services.reservation.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

public class Movie {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 400)
    private String title;

    public Movie(String title) {
        this.title = title;
    }
}
