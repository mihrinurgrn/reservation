package com.example.demo.service;

import com.example.demo.model.Reservation;

import java.util.List;

public interface ReservationService {
    void save(Reservation reservation);
    List<Reservation> getReservations(String userName);
}
