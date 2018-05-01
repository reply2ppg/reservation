/*
package com.ppg.services.reservation.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

public class SeatingSection {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 100)
    private String name;

    @ManyToOne
    private Theater theater;

    public SeatingSection(String name, Theater theater) {
        this.name = name;
        this.theater = theater;
    }
}
*/
