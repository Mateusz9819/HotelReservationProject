package com.example.demo.Reservation;

import com.example.demo.Controller.RoomService;

import java.time.LocalDate;

public class Reservation {
    private static Long counter = 1L;

    private Long id;
    private RoomService room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public Reservation() {
        this.id = counter++;
    }

    public Long getId() {
        return id;
    }

    public RoomService getRoom() {
        return room;
    }

    public void setRoom(RoomService room) {
        this.room = room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}
