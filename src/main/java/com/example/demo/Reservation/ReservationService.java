package com.example.demo.Reservation;

import com.example.demo.Controller.RoomService;
import com.example.demo.Reservation.Reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservationService {
    private List<Reservation> reservations;

    public ReservationService() {
        this.reservations = new ArrayList<>();
    }

    public Reservation getReservationById(Long id) {
        Optional<Reservation> foundReservation = reservations.stream()
                .filter(reservation -> reservation.getId().equals(id))
                .findFirst();

        return foundReservation.orElse(null);
    }

    public void makeReservation(RoomService room, LocalDate checkInDate, LocalDate checkOutDate) {
        // Sprawdzanie dostępności pokoju w danym okresie
        for (Reservation reservation : reservations) {
            if (reservation.getRoom().equals(room)) {
                LocalDate existingCheckIn = reservation.getCheckInDate();
                LocalDate existingCheckOut = reservation.getCheckOutDate();

                // Sprawdzenie czy istnieje konflikt z datami rezerwacji
                if ((checkInDate.isAfter(existingCheckIn) && checkInDate.isBefore(existingCheckOut)) ||
                        (checkOutDate.isAfter(existingCheckIn) && checkOutDate.isBefore(existingCheckOut))) {
                    throw new RuntimeException("Pokój jest już zarezerwowany w podanym terminie.");
                }
            }
        }

        // Tworzenie nowej rezerwacji i dodawanie do listy
        Reservation newReservation = new Reservation();
        newReservation.setRoom(room);
        newReservation.setCheckInDate(checkInDate);
        newReservation.setCheckOutDate(checkOutDate);

        reservations.add(newReservation);
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }

    public void cancelReservation(Reservation reservation) {
        reservations.remove(reservation);
    }
}
