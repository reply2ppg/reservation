package com.ppg.services.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieReservationController {

    @GetMapping("/moviereservation")
    public String home(Model model) {
        return "moviereservation";
    }
}