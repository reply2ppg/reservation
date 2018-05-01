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

public class Theater {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 100)
    private String name;

    @Column
    private String city;

    public Theater(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
