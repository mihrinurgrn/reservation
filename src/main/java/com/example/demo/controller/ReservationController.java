package com.example.demo.controller;

import com.example.demo.model.Reservation;
import com.example.demo.model.User;
import com.example.demo.service.ReservationService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @Autowired
    UserService userService;

    @PostMapping("/reservation/{userName}")
    Reservation newReservation(@RequestBody Reservation newReservation,@PathVariable String userName) {
        User user=userService.getUser(userName);
        newReservation.setUser(user);
        return reservationService.save(newReservation);
    }

    @GetMapping("/reservations/{userName}")
    List<Reservation> reservations(@PathVariable String userName) {

        return reservationService.getReservations(userName);
    }

}
