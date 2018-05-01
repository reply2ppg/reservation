package com.ppg.services.reservation;

import com.ppg.services.reservation.entity.Movie;
import com.ppg.services.reservation.entity.Theater;
import com.ppg.services.reservation.service.MovieService;
import com.ppg.services.reservation.service.PriceService;
import com.ppg.services.reservation.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ReservationApplication { // implements CommandLineRunner{

//	@Autowired
//	private TheaterService theaterService;
//
//	@Autowired
//	private MovieService movieService;
//
//	@Autowired
//    private PriceService priceService;

//	@Autowired
//	SeatingSectionService seatingSectionService;

	public static void main(String[] args) {
		SpringApplication.run(ReservationApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		movieService.getAllMovies().forEach(System.out::println);
//		theaterService.getAllTheater().forEach(System.out::println);
//
//		priceService.createPrice(Movie.builder().title("Roja").build(),
//                Theater.builder().city("Cincinnati").name("AMC").build(),
//                new Double("300.00"));
//
//        priceService.createPrice(Movie.builder().title("Sholay").build(),
//                Theater.builder().city("Cincinnati").name("Royal").build(),
//                new Double("100.00"));
//
//
//        priceService.createPrice(Movie.builder().title("Jurassic Park").build(),
//                Theater.builder().city("Cincinnati").name("Royal").build(),
//                new Double("400.00"));
//
//
//        priceService.createPrice(Movie.builder().title("Roja").build(),
//                Theater.builder().city("Cincinnati").name("Royal").build(),
//                new Double("250.00"));
//
//        priceService.createPrice(Movie.builder().title("Roja").build(),
//                Theater.builder().city("Dayton").name("AMC").build(),
//                new Double("300.00"));
//
//        priceService.createPrice(Movie.builder().title("Roja").build(),
//                Theater.builder().city("Columbus").name("Royal").build(),
//                new Double("250.00"));
//

//		seatingSectionService.createSeatingSection("Balcony", new Theater("AMC", "Cincinnati"));
//		seatingSectionService.createSeatingSection("Stall", new Theater("Royal", "Cincinnati"));
//		seatingSectionService.createSeatingSection("Balcony", new Theater("AMC", "Dayton"));
//		seatingSectionService.getSeatingSectionsByName("Balcony").forEach(System.out::println);
//	}
}
