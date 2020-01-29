package com.example.demo.service.Impl;

import com.example.demo.model.Reservation;
import com.example.demo.model.User;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Reservation save(Reservation reservation) {
        reservationRepository.save(reservation);
        return reservation;
    }

    @Override
    public List<Reservation> getReservations(String userName) {
        List<Reservation> reservations=new ArrayList<>();
        User user=userRepository.findUserByUserName(userName);
        reservations=reservationRepository.findReservationsByUser_UserId(user.getUserId());
        return reservations;
    }
}
