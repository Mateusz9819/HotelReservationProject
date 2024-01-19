package com.example.demo.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class RoomController {



        private final RoomService roomService;


        public RoomController(RoomService roomService) {
            this.roomService = roomService;
        }

        @GetMapping
        public String getAllRooms(Model model) {
            model.addAttribute("rooms", roomService.getAllRooms());
            return "rooms/all";
        }

        // Dodaj inne metody obsługujące zapytania HTTP dotyczące pokoi
    }


