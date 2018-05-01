package com.ppg.services.reservation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Price {
    @Id
    @GeneratedValue
    private Integer moviePriceId;

    @Column
    private Double moviePrice;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Theater theater;

/*
    @OneToOne
    private SeatingSection seatingSection;

    @OneToOne
    private ShowTime showTime;
*/

}
