package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelReservationApplication {

    public static void main(String[] args) {
        System.setProperty("server.port", "8889");

        // Ustawianie nowego portu (np. 8080)
        SpringApplication.run(HotelReservationApplication.class, args);
    }
}
